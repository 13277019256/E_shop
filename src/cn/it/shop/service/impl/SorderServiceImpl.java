package cn.it.shop.service.impl;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.SorderService;
@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {

	@Override
	public Forder addSorder(Forder forder, Product product) {
		boolean isHave = false; //���������û���ظ�������
		//�õ���ǰ�Ĺ�����
		Sorder sorder = productToSorder(product);
		//�жϵ�ǰ�������Ƿ��ظ�������ظ����������������
		for(Sorder old : forder.getSorders()) {
			if(old.getProduct().getId().equals(sorder.getProduct().getId())) {
				//���������ظ��������������
				old.setNumber(old.getNumber() + sorder.getNumber());
				isHave = true;
				break;
			}
		}
		//��ǰ�������ڹ��ﳵ�в����ڣ�����Ӽ���
		if(!isHave) {
			forder.getSorders().add(sorder);
		}
		return forder;
	}

	@Override
	public Sorder productToSorder(Product product) {
		Sorder sorder = new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}
}
