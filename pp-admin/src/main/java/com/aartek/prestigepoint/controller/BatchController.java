package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.Batch;
import com.aartek.prestigepoint.service.BatchService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.validator.BatchValidator;

/**
 * 
 * @author Dell
 *
 */
@Controller
public class BatchController {

	private static final Logger logger = Logger.getLogger(BatchController.class);

	@Autowired
	private BatchService batchService;

	@Autowired
	private BatchValidator batchValidator;

	/**
	 * display addBatch jsp for add batch.
	 * 
	 * @param map
	 * @param model
	 * @param message
	 * @param request
	 * @return
	 */
	@RequestMapping("/addBatch")
	public String addBatch(Map<String, Object> map, Model model, @RequestParam(required = false) String message) {
		List<Batch> batchList = batchService.getAllBatchName();
		logger.info("This is Info controller!");
		if (batchList != null) {
			model.addAttribute("batchList", batchList);
		}
		map.put("Batch", new Batch());
		model.addAttribute("message", message);
		return "addBatch";
	}

	/**
	 * Use for save and update a batch details.
	 * 
	 * @param batch
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @param batchId
	 * @return
	 */
	@RequestMapping(value = "/addBatchAction", method = { RequestMethod.GET, RequestMethod.POST })
	public String addBatchInfo(@ModelAttribute("Batch") Batch batch, BindingResult result, ModelMap model,
			Map<String, Object> map, HttpServletRequest request, @RequestParam(required = false) Integer batchId) {
		boolean status = false;
		List<Batch> batchList = batchService.getAllBatchName();
		String method = request.getMethod();
		if (("GET").equals(method)) {
			batch = batchService.editBatch(batchId);
			model.addAttribute("batchList", batchList);
			map.put("Batch", batch);
			return "addBatch";
		} else {
			model.addAttribute("batchList", batchList);
			if (batch.getBatchId() != null) {
				status = batchService.addBatch(batch);
				if (status) {
					model.addAttribute("message", IConstant.BATCH_EDIT_SUCCESS_MESSAGE);
				} else {
					model.addAttribute("message", IConstant.BATCH_EDIT_FAILURE_MESSAGE);
				}
			} else {
				batchValidator.validate(batch, result);
				if (result.hasErrors()) {
					return "addBatch";
				}
				status = batchService.addBatch(batch);
				if (status) {
					model.addAttribute("message", IConstant.BATCH_SUCCESS_MESSAGE);
				} else {
					model.addAttribute("message", IConstant.BATCH_FAILURE_MESSAGE);
				}
			}
			model.put("Batch", new Batch());
		}
		return "redirect:/addBatch.do";
	}

	/**
	 * Use for delete batch.
	 * 
	 * @param batch
	 * @param result
	 * @param model
	 * @param request
	 * @param batchId
	 * @return
	 */
	@RequestMapping(value = "/deleteBatch", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteCatageory(@ModelAttribute("Batch") Batch batch, ModelMap model,
			@RequestParam(required = false) Integer batchId) {
		batchService.deleteBatch(batchId);
		model.addAttribute("message", IConstant.BATCH_DELETE_MESSAGE);
		return "redirect:/addBatch.do";
	}

}
