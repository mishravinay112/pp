package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aartek.prestigepoint.model.AddChallenge;
import com.aartek.prestigepoint.service.ChallengeService;
import com.aartek.prestigepoint.util.IConstant;

/**
 * 
 * @author Meenal
 *
 */
@Controller
public class ChallengeController {

	private static final Logger logger = Logger.getLogger(ChallengeController.class);

	@Autowired
	private ChallengeService addChallengeService;

	/**
	 * display addChallenge jsp for add Challenge.
	 * 
	 * @param map
	 * @param model
	 * @param message
	 * @return
	 */

	@RequestMapping("/addChallenge")
	private String addChallenge(Map<String, Object> map, ModelMap model, @RequestParam(required = false) String message) {
		map.put("AddChallenge", new AddChallenge());

		List<AddChallenge> allAddChallengeList = addChallengeService.allAddChallengeList();
		logger.info("This is Info controller!");
		model.addAttribute("allAddChallengeList", allAddChallengeList);
		model.addAttribute("message", message);
		return "addChallenge";
	}

	/**
	 * Use for save ChallengeInformation.
	 * 
	 * @param addChallenge
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/addChallengeAction.do", method = { RequestMethod.GET, RequestMethod.POST })
	private String addChallengeInformation(@ModelAttribute("AddChallenge") AddChallenge addChallenge, ModelMap model) {
		if (addChallenge.getChallengeId() != null) {
			addChallengeService.addChallengeInformation(addChallenge);
			model.addAttribute("message", IConstant.CHALLENGE_UPDATE_MESSAGE);
		} else {
			addChallengeService.addChallengeInformation(addChallenge);
			model.addAttribute("message", IConstant.CHALLENGE_SUCCESS_MESSAGE);

		}

		return "redirect:/addChallenge.do";
	}

	/**
	 * Use for update ChallengeInformation.
	 * 
	 * @param addChallenge
	 * @param model
	 * @param map
	 * @param challengeId
	 * @return
	 */
	@RequestMapping(value = "/updateChallengeInformatin")
	public String updateChallengeInformation(@ModelAttribute("AddChallenge") AddChallenge addChallenge,
			Map<String, Object> map, @RequestParam(required = false) Integer challengeId) {
		addChallenge = addChallengeService.updateChallengeInformation(challengeId);
		map.put("AddChallenge", addChallenge);

		return "addChallenge";

	}

	/**
	 * Use for delete ChallengeInformation.
	 * 
	 * @param challengeId
	 * @return
	 */
	@RequestMapping(value = "/deleteChallengeInformation", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteStudentInformation(@RequestParam(required = false) Integer challengeId) {
		addChallengeService.deleteChallengeInformation(challengeId);
		logger.info("challengeId");
		return "redirect:/addChallenge.do";
	}

	/**
	 * Use for view the ChallengeInformation.
	 * 
	 * @param addChallenge
	 * @param model
	 * @param map
	 * @param challengeId
	 * @return
	 */
	@RequestMapping(value = "/viewChallengeInformation")
	public String viewChallengeList(@ModelAttribute("AddChallenge") AddChallenge addChallenge, ModelMap model,
			Map<String, Object> map, @RequestParam(required = false) Integer challengeId) {
		addChallenge = addChallengeService.updateChallengeInformation(challengeId);
		map.put("AddChallenge", addChallenge);
		return "viewChallenge";

	}

	/**
	 * Use for ActiveStatus.
	 * 
	 * @param challengeIdValue
	 * @param challengeValue
	 */
	@RequestMapping(value = "changeActiveStatusAction", method = RequestMethod.GET)
	@ResponseBody
	public void ActiveStatusinfo(@RequestParam(required = false) String challengeIdValue, Integer challengeValue) {
		addChallengeService.ChallengeValue(challengeIdValue, challengeValue);

	}
}
