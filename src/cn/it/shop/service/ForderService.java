package cn.it.shop.service;

import cn.it.shop.model.Forder;

public interface ForderService extends BaseService<Forder> {
	//���㹺���ܼ۸�
	public double cluTotal(Forder forder);
}
