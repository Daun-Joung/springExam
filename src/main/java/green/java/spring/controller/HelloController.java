package green.java.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.spring.vo.SpringPracDTO;

import green.java.spring.repository.DataDAO;

@Controller //�̷��� annotation�� ���� ������ �� ������ ã�� �Ϳ� �ʹ� ���� �ɸ��� �׷��� ���� �ɸ��� Spring Framework�� ����ϴ� ������ ��������.
//@RequestMapping("/spring") //�ϳ��ϳ��� ������Ʈ ������ �ִ� �ͺ��� ��Ʈ�ѷ� ��ü�� ������Ʈ ������ �ش�.
public class HelloController {

	@Autowired
	private DataDAO datadao; // 의존성 주입발생 → new DataDAO();이렇게 객체를 생성하는 것이아니라 @Autowired라는 annotation을 사용하면 자동으로 해당 클래스의 객체가 생성이 가능하다.
	
	
/*	@RequestMapping("/spring")
	public String hello(){
		
		return "/WEB-INF/file/hello.jsp";
	}
	*/
	@RequestMapping("/spring")
	public String main(/*@RequestParam String str*/) {
		return "/WEB-INF/file/hello.jsp";
	}
	
	@RequestMapping("/index")
	public String list(Model model) { // spring에서는 request, response가 아니라 model 객체를 활용하여 값을 jsp페이지와 주고 받는다.
		List<SpringPracDTO> list = datadao.getList();
		model.addAttribute("dblist", list);
		return "/WEB-INF/file/dbprint.jsp";
	
	}
	
	@RequestMapping("/insert")
	public String update() {
		return "/WEB-INF/file/dbInsert.jsp";
	}
	
	@RequestMapping("/insertdata")
	public String insertdata(@ModelAttribute SpringPracDTO vo,Model model) { // modelAttribute - jsp페이지에서 input submit으로 넘어온 모든 값들을 받아 올 때 사용하는 annotation 반드시 input의 이름들과 dto의 이름을 맞춰주어야 한다.
		
		datadao.insertData(vo);
		
		List<SpringPracDTO> list = datadao.getList();
		model.addAttribute("dblist",list);
		return "/WEB-INF/file/dbprint.jsp";
	}
	
	@RequestMapping("/deletedata")
	public String deletedata(@RequestParam String id,Model model) {
		
		datadao.deleteData(id);
		
		List<SpringPracDTO> list = datadao.getList();
		model.addAttribute("dblist",list);
		return "/WEB-INF/file/dbprint.jsp";
	}
}