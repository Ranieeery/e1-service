package br.com.empresa1.report.service.command.read;

import com.avenuecode.core.service.command.hibernate.AbstractHibernateReadCommand;
import com.avenuecode.core.service.command.hibernate.HibernateCommand;

import br.com.empresa1.report.dto.backoffice.PedidoReciboDTO;
import br.com.empresa1.report.service.command.response.OrderReceiptResponse;
import br.com.empresa1.report.service.dao.OrderReceiptDao;

@HibernateCommand
public class ReadOrderReceiptCommand extends AbstractHibernateReadCommand<OrderReceiptDao,PedidoReciboDTO,Long,ReadOrderReceiptRequest,OrderReceiptResponse> {
}
