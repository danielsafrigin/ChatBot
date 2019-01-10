package org.chatbot.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.chatbot.model.AjaxResponseBody;
import org.chatbot.model.QuestionCriteria;
import org.chatbot.services.QAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

	@Autowired
	QAService QAService;

	@PostMapping("/api/search")
	public ResponseEntity<?> getAnswerResultViaAjax(@Valid @RequestBody QuestionCriteria question, Errors errors) {
		AjaxResponseBody result = new AjaxResponseBody();

		// If error, just return a 400 bad request, along with the error message
		if (errors.hasErrors()) {
			result.setMsg(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			return ResponseEntity.badRequest().body(result);
		}

		result.setMsg("success");
		result.setResult(QAService.getAnswer(question.getQuestion()));

		return ResponseEntity.ok(result);

	}
}
