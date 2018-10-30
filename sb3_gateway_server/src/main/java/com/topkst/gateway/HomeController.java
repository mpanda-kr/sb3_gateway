package com.topkst.gateway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.topkst.gateway.dao.BeaconTokenService;
import com.topkst.gateway.dao.EnrollBeaconService;
import com.topkst.gateway.dao.EnrollListService;
import com.topkst.gateway.dao.RidingBeaconService;
import com.topkst.gateway.dao.ScanBeaconDAO;
import com.topkst.gateway.dao.ScanBeaconService;
import com.topkst.gateway.dao.TodayDataService;
import com.topkst.gateway.dto.BeaconToken;
import com.topkst.gateway.dto.EnrollBeacon;
import com.topkst.gateway.dto.RidingBeacon;
import com.topkst.gateway.dto.RidingGetBeacon;
import com.topkst.gateway.dto.ScanBeacon;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	EnrollBeaconService beaconService;

	@Autowired
	ScanBeaconService scanBeaconService;

	@Autowired
	RidingBeaconService ridingBeaconService;

	@Autowired
	EnrollListService enrollListService;

	@Autowired
	BeaconTokenService beaconTokenService;

	@Autowired
	TodayDataService dataService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "enroll_scan", method = RequestMethod.GET)
	public String enroll_scan(Locale locale, Model model) {

		return "enroll_scan";
	}

	@RequestMapping(value = "enroll_scan_beacon", method = RequestMethod.GET)
	public String enroll_scan_beacon(Locale locale, Model model) {

		return "enroll_scan_beacon";
	}

	// ��ȿ���� ���� > ����Ʈ����
	@RequestMapping(value = "ajax_enrollbeacon_select")
	@ResponseBody
	public List<EnrollBeacon> enroll_list_ajax(HttpServletRequest request, Model model) {

		// String center_code = "2109059_01";
		// center_id = (String)request.getParameter("center_id");
		String center_code = (String) request.getParameter("center_id");

		System.out.println("[" + center_code + "] ������ ��ȿ ���� ��");
		List<EnrollBeacon> enroll_beacon_list = beaconService.center_getEnrollBeaconList(center_code);

		return enroll_beacon_list;

	}
	// ��ȿ���� ���� > ����Ʈ����

	@RequestMapping(value = "center_enrollbeacon_select")
	@ResponseBody
	public List<EnrollBeacon> enroll_list(HttpServletRequest request, Model model) {

		//String center_code = "2109058_04";
		// center_id = (String)request.getParameter("center_id");
		String center_code = (String) request.getParameter("center_id");

		System.out.println(center_code);
		List<EnrollBeacon> enroll_beacon_list = beaconService.center_getEnrollBeaconList(center_code);
		System.out.println("[" + center_code + "] ����Ʈ���̿� �ԷµǾ� ��ȿ ������ ����Ʈ���̷� �۽ŵǾ����ϴ�. \n ");
		return enroll_beacon_list;

	}

	@RequestMapping(value = "test")
	@ResponseBody
	public List<BeaconToken> testl_list(HttpServletRequest request, Model model) {

		int _id = 1497;
		List<BeaconToken> beacontoken_list = beaconTokenService.getBeaconTokenList("2109058_04_B_001");

		// List<RidingGetBeacon> riding_list = ridingBeaconService.get_riding_list(_id);

		System.out.println("===========");
		System.out.println(beacontoken_list);

		return beacontoken_list;

	}

	@RequestMapping(value = "/saveChartConfig")
	public @ResponseBody String processSaveChartConfig(@RequestBody String json)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> jsonToMap = new ObjectMapper().readValue(json, Map.class);
		String templateName = (String) jsonToMap.get("templateName"); // here you get the parameters
		return templateName; // For example
	}

	// ����Ʈ���� json ������ > ����
	@RequestMapping(value = "enrollbeacon_insert")
	@ResponseBody
	public String scan_beacon(HttpServletRequest request, Model model)
			throws org.json.simple.parser.ParseException, ParseException, IOException {

		// dao.medicine(request.getParameter("request_date"),
		// request.getParameter("symptom"), request.getParameter("medicine_category"),
		// request.getParameter("medicine_amount"),
		// request.getParameter("medicine_count"),
		// request.getParameter("medicine_time"),
		// request.getParameter("medicine_storage"),
		// request.getParameter("medicine_content"),
		// request.getParameter("sign_bitmap_bytecode"));

		System.out.println("=======================================");
		String jsonInfo = request.getReader().lines().collect(Collectors.joining());
		System.out.println(jsonInfo);
		// String jsonInfo =
		// "{\"enroll_beacon\":[{\"gateway\":\"2109059_01_G0_01\",\"center\":\"2109059_01\",\"createtime\":\"2017-11-06
		// 15:16:36.580655\",\"mac_address\":\"e4:e3:2b:90:cb:8c\",\"uuid\":\"b9407f30f5f8466eaff925556b57fe6d\",\"major\":6304,\"minor\":23260,\"rssi\":-72,\"tx_power\":-73},{\"gateway\":\"2109059_01_G0_01\",\"center\":\"2109059_01\",\"createtime\":\"2017-11-06
		// 15:17:08.724904\",\"mac_address\":\"e4:e3:2b:90:cb:8c\",\"uuid\":\"b9407f30f5f8466eaff925556b57fe6d\",\"major\":6304,\"minor\":23260,\"rssi\":-72,\"tx_power\":-73},{\"gateway\":\"2109059_01_G0_01\",\"center\":\"2109059_01\",\"createtime\":\"2017-11-06
		// 15:17:11.169187\",\"mac_address\":\"e4:e3:2b:90:cb:8c\",\"uuid\":\"b9407f30f5f8466eaff925556b57fe6d\",\"major\":6304,\"minor\":23260,\"rssi\":-72,\"tx_power\":-69}]}\n"
		// ;

		JSONParser jsonParser = new JSONParser();

		// JSON�����͸� �־� JSON Object �� ����� �ش�.
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo);

		// books�� �迭�� ����
		JSONArray beaconInfoArray = (JSONArray) jsonObject.get("enroll_beacon");
		ScanBeacon beacon = new ScanBeacon();

		for (int i = 0; i < beaconInfoArray.size(); i++) {

			// �迭 �ȿ� �ִ°͵� JSON���� �̱� ������ JSON Object �� ����
			JSONObject baconObject = (JSONObject) beaconInfoArray.get(i);

			beacon.setGateway((String) baconObject.get("gateway"));
			beacon.setCenter((String) baconObject.get("center"));

			String date = (String) baconObject.get("createtime"); // YYYY-MM-DD
			System.out.println(date);

			beacon.setCreatetime(date);

			beacon.setMac_address((String) baconObject.get("mac_address"));
			beacon.setUuid((String) baconObject.get("uuid"));
			beacon.setMajor(((Long) baconObject.get("major")).intValue());
			beacon.setMinor(((Long) baconObject.get("minor")).intValue());
			beacon.setRssi(((Long) baconObject.get("rssi")).intValue());
			beacon.setTx_power(((Long) baconObject.get("tx_power")).intValue());

			System.out.println("=================== enroll_beacon " + (i + 1) + " =======================");

			System.out.println("beacon.getCenter() = " + beacon.getCenter() + "\nbeacon.getGateway() = "
					+ beacon.getGateway() + "\nbeacon.getCratedate() = " + beacon.getCreatetime()
					+ "\nbeacon.getMac_address() = " + beacon.getMac_address() + "\nbeacon.getUuid() = "
					+ beacon.getUuid() + "\nbeacon.getMajor() = " + beacon.getMajor() + "\nbeacon.getMinor() = "
					+ beacon.getMinor() + "\nbeacon.getRssi() = " + beacon.getRssi() + "\nbeacon.getTx_power() = "
					+ beacon.getTx_power());

			scanBeaconService.setScanBeacon(beacon);
		}

		return "home";
	}

	// ����Ʈ���� json ������ > ����
	@RequestMapping(value = "ultra_insert")
	@ResponseBody
	public String ultra_beacon(HttpServletRequest request, Model model)
			throws org.json.simple.parser.ParseException, ParseException, IOException {

		System.out.println("================== ultra_beacon =====================");
		String jsonInfo = request.getReader().lines().collect(Collectors.joining());
		// System.out.println(jsonInfo);
		// String jsonInfo =
		// "{\"enroll_beacon\":[{\"gateway\":\"2109059_01_G0_01\",\"center\":\"2109059_01\",\"createtime\":\"2017-11-06
		// 15:16:36.580655\",\"mac_address\":\"e4:e3:2b:90:cb:8c\",\"uuid\":\"b9407f30f5f8466eaff925556b57fe6d\",\"major\":6304,\"minor\":23260,\"rssi\":-72,\"tx_power\":-73},{\"gateway\":\"2109059_01_G0_01\",\"center\":\"2109059_01\",\"createtime\":\"2017-11-06
		// 15:17:08.724904\",\"mac_address\":\"e4:e3:2b:90:cb:8c\",\"uuid\":\"b9407f30f5f8466eaff925556b57fe6d\",\"major\":6304,\"minor\":23260,\"rssi\":-72,\"tx_power\":-73},{\"gateway\":\"2109059_01_G0_01\",\"center\":\"2109059_01\",\"createtime\":\"2017-11-06
		// 15:17:11.169187\",\"mac_address\":\"e4:e3:2b:90:cb:8c\",\"uuid\":\"b9407f30f5f8466eaff925556b57fe6d\",\"major\":6304,\"minor\":23260,\"rssi\":-72,\"tx_power\":-69}]}\n"
		// ;

		JSONParser jsonParser2 = new JSONParser();
		JSONObject jsonObject2 = (JSONObject) jsonParser2.parse(jsonInfo);
		JSONArray beaconInfoArray = (JSONArray) jsonObject2.get("enroll_beacon");
		ScanBeacon beacon = new ScanBeacon();

		for (int i = 0; i < beaconInfoArray.size(); i++) {

			JSONObject baconObject = (JSONObject) beaconInfoArray.get(i);

			beacon.setGateway((String) baconObject.get("gateway"));
			beacon.setCenter((String) baconObject.get("center"));

			String date = (String) baconObject.get("createtime");
			beacon.setCreatetime(date);

			beacon.setMac_address((String) baconObject.get("mac_address"));
			beacon.setUuid((String) baconObject.get("uuid"));
			beacon.setMajor(((Long) baconObject.get("major")).intValue());
			beacon.setMinor(((Long) baconObject.get("minor")).intValue());
			beacon.setRssi(((Long) baconObject.get("rssi")).intValue());
			beacon.setTx_power(((Long) baconObject.get("tx_power")).intValue());

			System.out.println("=================== ultra_beacon " + (i + 1) + " =======================");

			System.out.println("beacon.getCenter() = " + beacon.getCenter() + "\nbeacon.getGateway() = "
					+ beacon.getGateway() + "\nbeacon.getCratedate() = " + beacon.getCreatetime()
					+ "\nbeacon.getMac_address() = " + beacon.getMac_address() + "\nbeacon.getUuid() = "
					+ beacon.getUuid() + "\nbeacon.getMajor() = " + beacon.getMajor() + "\nbeacon.getMinor() = "
					+ beacon.getMinor() + "\nbeacon.getRssi() = " + beacon.getRssi() + "\nbeacon.getTx_power() = "
					+ beacon.getTx_power());

			scanBeaconService.setUltraBeacon(beacon);
		}

		return "home";
	}

	@ResponseBody
	@RequestMapping(value = "check", method = RequestMethod.POST)
	public HashMap<String, Object> checkTeacher(@RequestParam HashMap<String, Object> param) {
		String center_code = (String) param.get("center_code");
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		List<EnrollBeacon> enroll_beacon_list = beaconService.center_getEnrollBeaconList(center_code);
		hashmap.put("list", enroll_beacon_list);
		return hashmap;

	}

	@ResponseBody
	@RequestMapping(value = "enroll_list", method = RequestMethod.POST)
	public HashMap<String, Object> EnrollList(@RequestParam HashMap<String, Object> param) {

		String center_code = (String) param.get("center_code");
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		List<ScanBeacon> enroll_list = enrollListService.getenroll_list(center_code);
		hashmap.put("list", enroll_list);
		return hashmap;

	}

	@ResponseBody
	@RequestMapping(value = "make_today_data")
	public String TodauData(@RequestParam HashMap<String, Object> param) {

		dataService.setTodayData();
		return "home";
	}

	// ����Ʈ���� json ������ > ����
	   @RequestMapping(value = "riding_insert")
	   @ResponseBody
	   public JSONObject scan_beacon_riding(HttpServletRequest request, Model model)
	         throws org.json.simple.parser.ParseException, ParseException, IOException {

	      System.out.println("==================come data=====================");
	      String jsonInfo = request.getReader().lines().collect(Collectors.joining());
	      //String jsonInfo = "{\"riding_beacon\":[{\"_id\":\"11450\",\"beacon_id\":\"2109058_04_B_001\",\"createtime\":\"2018-01-30 06:14:19.828832\",\"data_type\":\"getoff\",\"equiment_id\":\"2109059_01_G0_01\"}]}";
	   
	      System.out.println(jsonInfo);

	      JSONParser jsonParser = new JSONParser();
	      JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo);
	      JSONArray beaconInfoArray = (JSONArray) jsonObject.get("riding_beacon");
	      
	      //String msg_type = "parent_real_bus"

	      RidingBeacon ridingBeacon = new RidingBeacon();

	      JSONObject obj = new JSONObject();
	      JSONArray jArray = new JSONArray();

	      for (int i = 0; i < beaconInfoArray.size(); i++) {
	         JSONObject baconObject = (JSONObject) beaconInfoArray.get(i);
	         int _id = Integer.parseInt((String) baconObject.get("_id"));
	         ridingBeacon.set_id(_id);

	         ridingBeacon.setBeacon_id((String) baconObject.get("beacon_id"));
	         String date = (String) baconObject.get("createtime");
	         ridingBeacon.setCreatetime(date);
	         ridingBeacon.setData_type((String) baconObject.get("data_type"));
	         ridingBeacon.setEquiment_id((String) baconObject.get("equiment_id"));
	         ridingBeacon.setReceive(1);

	         ridingBeaconService.setRidingBeacon(ridingBeacon);

	         // ���� Ȯ��.

	         List<RidingGetBeacon> riding_list = ridingBeaconService.get_riding_list(_id);
	         System.out.println("_id : " + _id + "riding_list : " + riding_list.get(0).getLog_receive());

	         if (riding_list.get(0).getLog_receive() == 1) {
	            JSONObject sObject = new JSONObject();
	            sObject.put("_id", riding_list.get(0).getLog_id());
	            jArray.add(sObject);
	         }

	         String beacon_id = (String) baconObject.get("beacon_id");

	         List<BeaconToken> beacontoken_list = beaconTokenService.getBeaconTokenList(beacon_id);

	         System.out.println("beacon_id : " + beacon_id);

	         try {
	            if (!beacontoken_list.get(0).equals("")) {

	               for (int j = 0; j < beacontoken_list.size(); j++) {
	                  if (beacontoken_list.get(j).equals("")) {
	                     continue;
	                  }
	                  // ����� Ǫ�þ˶� ������
	                  try {
	                  final String apiKey = "AAAAQuz7CBI:APA91bEdABgVn76hQd-CispwSrHvcxz-AX7ZffRLsGxG84LlFnzAy1lMd4eoRbDmfS4xw1bAKiyf8AwJVGq7-zyY9xtEE5DH31EepNAUqY8Zx3K8P4PNjHhpyMZLu5dDLrOTbcJdi5ll";
	                  URL url = new URL("https://fcm.googleapis.com/fcm/send");
	                  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	                  conn.setDoOutput(true);
	                  conn.setRequestMethod("POST");
	                  conn.setRequestProperty("Content-Type", "application/json");
	                  conn.setRequestProperty("Authorization", "key=" + apiKey);

	                  conn.setDoOutput(true);

	                  String userId = (String) request.getSession().getAttribute("ssUserId");

	                  // String test="�̷��� �ȴٰ�"+kid_name+"�̷��� �ȴٰ�";
	                  // System.out.println(test);

	                  // �̰ɷ� ������ Ư�� ��ū�� �������ִ� ���ÿ��� �˸��� �����ش� ���� ���߿� �Ѱ� ��� ��������
	                  // String input = "{\"data\" : {\"title\" :
	                  // \""+kid_name+"("+class_name+")"+"�����Ƿڼ� �ۼ� \", \"body\" : \"����� ���� �ֱ�\"},
	                  // \"to\":\"fPN_92XlmuE:APA91bFnrRt8fbwS6BjV0wwvK4mYwwXjvqfUILEoi7PzemIAlGehtFPqRrkGe0cdwPqIhF1hxTi0yJHbRc89hKM-fiRAUQBn-yOsg74_YUIJQ1rsL2SZUGKK-iFbuy1l3nQfTU5VHRL3\"}";

	                  String input = "";
	                  if ((boolean) baconObject.get("data_type").equals("getoff") == true) {
	                     System.out.println("�����Ҳٴپƾƾ�");
	                     //input = "{\"data\" : {\"title\" : \"" + ""+ " ��ġ�� ���� ���� \", \"body\" : \"���� �˶�\", \"msg_type\" : \""+msg_type+"\"}, \"to\":\""+ beacontoken_list.get(j).getFcm_token() + "\"}";
	                     input = "{\"data\" : {\"title\" : \"" + ""
	                             + " ��ġ�� ���� ���� \", \"body\" : \"���� �˶�\"}, \"to\":\""
	                             + beacontoken_list.get(j).getFcm_token() + "\"}";
	                    
	                     
	                     
	                     
	                     
	                     
	                  } else {
	                     System.out.println("�����Ҳٴپƾƾ�");
	                     input = "{\"data\" : {\"title\" : \"" + ""
	                           + " ��ġ�� ���� ���� \", \"body\" : \"���� �˶�\"}, \"to\":\""
	                           + beacontoken_list.get(j).getFcm_token() + "\"}";
	                  }

	                  OutputStream os = conn.getOutputStream();

	                  // �������� ������ �ѱ� ������ ����� �Ʒ�ó�� UTF-8�� ���ڵ��ؼ� ��������
	                  os.write(input.getBytes("UTF-8"));
	                  os.flush();
	                  os.close();

	                  int responseCode = conn.getResponseCode();
	                  // System.out.println("\nSending 'POST' request to URL : " + url);
	                  // System.out.println("Post parameters : " + input);
	                  // System.out.println("Response Code : " + responseCode);

	                  BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	                  String inputLine;
	                  StringBuffer response = new StringBuffer();

	                  while ((inputLine = in.readLine()) != null) {
	                     response.append(inputLine);
	                  }
	                  in.close();
	                  }catch(Exception e) {
	                           System.out.println("��ū����");
	                           e.printStackTrace();
	                        }
	                  // print result
	                  // System.out.println(response.toString());
	               }
	            }
	         } catch (Exception e) {
	         }

	      }

	      obj.put("receive_message", jArray);
	      System.out.println(obj.toString());

	      System.out.println("==================road data=====================");
	      return obj;
	      
	   }

	// ����Ʈ���� json ������ > ����
	@RequestMapping(value = "attendence_insert")
	@ResponseBody
	public JSONObject scan_beacon_attendence(HttpServletRequest request, Model model)
			throws org.json.simple.parser.ParseException, ParseException, IOException {

		System.out.println("==================come data=====================");
		String jsonInfo = request.getReader().lines().collect(Collectors.joining());
		//String jsonInfo = "{\"riding_beacon\":[{\"_id\":\"1\",\"beacon_id\":\"2109058_04_B_001\",\"createtime\":\"2018-03-30 15:07:34.941406\",\"data_type\":\"comein\",\"equiment_id\":\"2109059_04_G0_01\"},{\"_id\":\"2\",\"beacon_id\":\"2109058_04_B_005\",\"createtime\":\"2018-03-30 15:07:35.408422\",\"data_type\":\"comein\",\"equiment_id\":\"2109059_04_G0_01\"},{\"_id\":\"3\",\"beacon_id\":\"2109058_04_B_003\",\"createtime\":\"2018-03-30 15:07:35.522558\",\"data_type\":\"comein\",\"equiment_id\":\"2109059_04_G0_01\"},{\"_id\":\"4\",\"beacon_id\":\"2109058_04_B_004\",\"createtime\":\"2018-03-30 15:07:36.339296\",\"data_type\":\"comein\",\"equiment_id\":\"2109059_04_G0_01\"},{\"_id\":\"5\",\"beacon_id\":\"2109058_04_B_006\",\"createtime\":\"2018-03-30 15:07:36.801378\",\"data_type\":\"comein\",\"equiment_id\":\"2109059_04_G0_01\"}]}";
		System.out.println(jsonInfo);

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo);
		JSONArray beaconInfoArray = (JSONArray) jsonObject.get("riding_beacon");

		RidingBeacon ridingBeacon = new RidingBeacon();

		JSONObject obj = new JSONObject();
		JSONArray jArray = new JSONArray();

		SimpleDateFormat sdf = new SimpleDateFormat("H:mm:ss"); // H�� �ð� ������ 24
		Time time = new Time(System.currentTimeMillis());
		Time time2 = new Time(12, 00, 00);

		for (int i = 0; i < beaconInfoArray.size(); i++) {
			JSONObject baconObject = (JSONObject) beaconInfoArray.get(i);
			int _id = Integer.parseInt((String) baconObject.get("_id"));
			ridingBeacon.set_id(_id);

			ridingBeacon.setBeacon_id((String) baconObject.get("beacon_id"));
			String date = (String) baconObject.get("createtime");
			ridingBeacon.setCreatetime(date);
			ridingBeacon.setData_type((String) baconObject.get("data_type"));
			ridingBeacon.setEquiment_id((String) baconObject.get("equiment_id"));
			ridingBeacon.setReceive(1);

			ridingBeaconService.setAttendBeacon(ridingBeacon);

			// ���� Ȯ��.

			List<RidingGetBeacon> riding_list = ridingBeaconService.get_attend_list(_id);
			System.out.println("_id : " + _id + "riding_list : " + riding_list.get(0).getLog_receive());

			if (riding_list.get(0).getLog_receive() == 1) {
				JSONObject sObject = new JSONObject();
				sObject.put("_id", riding_list.get(0).getLog_id());
				jArray.add(sObject);
			}

			String beacon_id = (String) baconObject.get("beacon_id");

			List<BeaconToken> beacontoken_list = beaconTokenService.getBeaconTokenList(beacon_id);

			System.out.println("beacontoken_list : " + beacontoken_list);

			try {
				if (!beacontoken_list.get(0).equals("")) {

					for (int j = 0; j < beacontoken_list.size(); j++) {
						if (beacontoken_list.get(j).equals("")) {
							continue;
						}
						try {
						// ����� Ǫ�þ˶� ������
						final String apiKey = "AAAAQuz7CBI:APA91bEdABgVn76hQd-CispwSrHvcxz-AX7ZffRLsGxG84LlFnzAy1lMd4eoRbDmfS4xw1bAKiyf8AwJVGq7-zyY9xtEE5DH31EepNAUqY8Zx3K8P4PNjHhpyMZLu5dDLrOTbcJdi5ll";
						URL url = new URL("https://fcm.googleapis.com/fcm/send");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setDoOutput(true);
						conn.setRequestMethod("POST");
						conn.setRequestProperty("Content-Type", "application/json");
						conn.setRequestProperty("Authorization", "key=" + apiKey);

						conn.setDoOutput(true);

						String userId = (String) request.getSession().getAttribute("ssUserId");

						// String test="�̷��� �ȴٰ�"+kid_name+"�̷��� �ȴٰ�";
						// System.out.println(test);

						// �̰ɷ� ������ Ư�� ��ū�� �������ִ� ���ÿ��� �˸��� �����ش� ���� ���߿� �Ѱ� ��� ��������
						// String input = "{\"data\" : {\"title\" :
						// \""+kid_name+"("+class_name+")"+"�����Ƿڼ� �ۼ� \", \"body\" : \"����� ���� �ֱ�\"},
						// \"to\":\"fPN_92XlmuE:APA91bFnrRt8fbwS6BjV0wwvK4mYwwXjvqfUILEoi7PzemIAlGehtFPqRrkGe0cdwPqIhF1hxTi0yJHbRc89hKM-fiRAUQBn-yOsg74_YUIJQ1rsL2SZUGKK-iFbuy1l3nQfTU5VHRL3\"}";

						String input = "";
						if ((boolean) baconObject.get("data_type").equals("comein") == true) {
							System.out.println("��������" + time.before(time2));

							System.out.println(sdf.format(time));
							System.out.println(sdf.format(time2));

							if (time.after(time2)) {

								System.out.println("����Ҳٴپƾƾ�");
								input = "{\"data\" : {\"title\" : \"" + ""
										+ " ��ġ�� ���� ���� \", \"body\" : \"���� �̷� ����\"}, \"to\":\""
										+ beacontoken_list.get(j).getFcm_token() + "\"}";
							}

							else {
								System.out.println("�Ͽ��Ҳٴپƾƾ�");
								input = "{\"data\" : {\"title\" : \"" + ""
										+ " ��ġ�� ���� ���� \", \"body\" : \"�Ͽ� �̷� ����\"}, \"to\":\""
										+ beacontoken_list.get(j).getFcm_token() + "\"}";
							}

						}
						OutputStream os = conn.getOutputStream();

						// �������� ������ �ѱ� ������ ����� �Ʒ�ó�� UTF-8�� ���ڵ��ؼ� ��������
						os.write(input.getBytes("UTF-8"));
						os.flush();
						os.close();

						int responseCode = conn.getResponseCode();
						// System.out.println("\nSending 'POST' request to URL : " + url);
						// System.out.println("Post parameters : " + input);
						// System.out.println("Response Code : " + responseCode);

						BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						String inputLine;
						StringBuffer response = new StringBuffer();

						while ((inputLine = in.readLine()) != null) {
							response.append(inputLine);
						}
						in.close();
						}catch(Exception e) {
			                  System.out.println("��ū����");
			                  e.printStackTrace();
			               }
						// print result
						// System.out.println(response.toString());
					}
				}
			} catch (Exception e) {
			}

		}

		obj.put("receive_message", jArray);
		System.out.println(obj.toString());

		System.out.println("==================load data=====================");
		return obj;

	}
}
