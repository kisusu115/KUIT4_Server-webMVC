package jwp.controller.question;

import core.db.DBAnswerRepository;
import core.db.DBQuestionRepository;
import core.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Long questionId = Long.valueOf(req.getParameter("questionId"));
        req.setAttribute("question", DBQuestionRepository.getInstance().findQuestionById(questionId));
        req.setAttribute("answers", DBAnswerRepository.getInstance().findAllByQuestionId(questionId));
        return "/qna/show.jsp";
    }
}
