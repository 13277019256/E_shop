package cn.it.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CategoryAction extends BaseAction<Category> {
	
	public String update() {
		System.out.println("----update----");
		categoryService.update(model);
		return "index";
	}
	
	public String save() {
		System.out.println("----save----");
		System.out.println(model);
		return "index";
	}
	
	public String query() {
		//�������һ��������Ӧ��mapȡ��ԭ�������ö���������jspû�����������Ǵ������Ƚϴ�
//		ActionContext.getContext().put("categoryList", categoryService.query()); //�ŵ�request����
//		ActionContext.getContext().getSession().put("categoryList", categoryService.query()); //�ŵ�session����
//		ActionContext.getContext().getApplication().put("categoryList", categoryService.query()); //�ŵ�application����
		
		//�����������ʵ����Ӧ�Ľӿ�(RequestAware,SessionAware,ApplicationAware)������Ӧ��mapע��
		request.put("categoryList", categoryService.query()); 
		session.put("categoryList", categoryService.query()); 
		application.put("categoryList", categoryService.query()); 
		return "index";
	}

}
