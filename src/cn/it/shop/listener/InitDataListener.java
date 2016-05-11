package cn.it.shop.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;
/**
 * @Description: TODO(������Ŀ������ʱ�����ݳ�ʼ��)
 * @author Ni Shengwu
 *
 */
//@Component //��������web������������tomcatʵ�����ģ�����Springʵ�����ġ����ܷŵ�Spring��
public class InitDataListener implements ServletContextListener {
	
	private ProductService productService = null;
	private CategoryService categoryService = null;
	private ApplicationContext context = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// �������һ�����Լ���productService������Spring�����е�service��ʵ������2�Σ���Ϊ�����ּ�����һ�Ρ�����ȡ��
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		productService = (ProductService) context.getBean("productService");
//		System.out.println(productService);
//		
		// �������������Ŀ������ʱ����Spring�����ļ�ͨ��Spring�ļ��������أ��洢��ServletContext�У�����ֻҪ��ServletContext�л�ȡ���ɡ�
		// �˷�����key�Ƚϳ��������׼�ס
//		ApplicationContext context = (ApplicationContext) event.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		productService = (ProductService) context.getBean("productService");
//		System.out.println(productService);
		
		// �����������ͨ����������ؼ���
		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());		
		categoryService = (CategoryService) context.getBean("categoryService");//���������Ϣ		
		productService = (ProductService) context.getBean("productService");//������Ʒ��Ϣ

		List<List<Product>> bigList = new ArrayList<List<Product>>(); //bigList�д��һ��װ��Category���list
		// 1. ��ѯ���ȵ����
		for(Category category : categoryService.queryByHot(true)) {
			//�����ȵ����id��ȡ�Ƽ���Ʒ��Ϣ
			List<Product> lst = productService.querByCategoryId(category.getId());
			bigList.add(lst); //��װ��category��list�ŵ�bigList��
		}
		// 2. �Ѳ�ѯ��bigList����application���ö���
		event.getServletContext().setAttribute("bigList", bigList);
	}

}
