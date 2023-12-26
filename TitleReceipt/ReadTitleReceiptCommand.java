package br.com.empresa1.report.service.command.read;

import com.avenuecode.core.service.command.hibernate.AbstractHibernateReadCommand;
import com.avenuecode.core.service.command.hibernate.HibernateCommand;

import br.com.empresa1.report.dto.backoffice.TituloReciboDTO;
import br.com.empresa1.report.service.command.response.TitleReceiptResponse;
import br.com.empresa1.report.service.dao.TitleReceiptDao;

@HibernateCommand
public class ReadTitleReceiptCommand extends AbstractHibernateReadCommand<TitleReceiptDao,TituloReciboDTO,Long,ReadTitleReceiptRequest,TitleReceiptResponse> {
}
