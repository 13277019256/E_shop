package cn.it.shop.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.it.shop.model.Category;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * Strutsִ�����̣��ȴ���Action���ٵ��������������������ʳɹ��ٵ���Action�ķ���
 * ����Ŀ������ʱ��Struts�Ĺ��������Ѿ�����Ӧ�����ö��󣬺����ö����Ӧ��Map�洢����ActionContext��ֵջ��
 * ���ʵ������Ӧ��xxxAware�ӿڣ��ͻ��ActionContext�л�ȡ��Ӧ��Map���д��롣ʵ�������������Ϊ��servletConfig
 * servletConfig�������´��룺�жϵ�ǰʵ��ʲô�ӿڣ����ע����Ӧ�Ķ���
 * if (action instanceof ApplicationAware) {
            ((ApplicationAware) action).setApplication(context.getApplication());
        }
        
   if (action instanceof SessionAware) {
            ((SessionAware) action).setSession(context.getSession());
        }
        
   if (action instanceof RequestAware) {
            ((RequestAware) action).setRequest((Map) context.get("request"));
        }
 */
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T> {

	//service����
	protected CategoryService categoryService;
	protected AccountService accountService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	//�����
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
		
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	//ModelDriven
	protected T model;
	@Override
	public T getModel() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		Class clazz = (Class)type.getActualTypeArguments()[0];
		try {
			model = (T)clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
		return model;
	}
}
