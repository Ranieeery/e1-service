package br.com.empresa1.report.service.dao;

import com.avenuecode.core.service.dao.hibernate.AbstractHibernateDao;
import com.avenuecode.core.service.dao.hibernate.HibernateDao;

import br.com.empresa1.report.dto.backoffice.PedidoReciboDTO;

@HibernateDao
public class OrderReceiptDao extends AbstractHibernateDao<PedidoReciboDTO, Long>{

}
