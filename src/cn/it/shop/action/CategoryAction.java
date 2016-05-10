package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {
	
	public String queryJoinAccount() {
		System.out.println("type:" + model.getType());
		System.out.println("page��" + page);
		System.out.println("rows��" + rows);
		
		//�����洢��ҳ������
		pageMap = new HashMap<String, Object>();
		
		//���ݹؼ��ֺͷ�ҳ�Ĳ�����ѯ��Ӧ������
		List<Category> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
		pageMap.put("rows", categoryList); //�洢ΪJSON��ʽ
		//���ݹؼ��ֲ�ѯ�ܼ�¼��
		Long total = categoryService.getCount(model.getType());
//		System.out.println(total);
		pageMap.put("total", total); //�洢ΪJSON��ʽ

		return "jsonMap";
	}
	
	public String deleteByIds() {
		System.out.println(ids);
		categoryService.deleteByIds(ids);
		//���ɾ���ɹ��ͻ�����ִ�У����ǽ�"true"��������ʽ����ǰ̨
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save() {
		System.out.println(model);
		categoryService.save(model);
	}
	
	public void update() {
		System.out.println(model);
		categoryService.update(model);
	}
	
	public String query() {
		jsonList = categoryService.query();
		return "jsonList";
	}
}
