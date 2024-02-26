package br.com.empresa1.report.service.command.update;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Query;

import com.avenuecode.core.service.command.hibernate.AbstractHibernateNativeCreateCommand;
import com.avenuecode.core.service.command.response.GenericCreateUpdateNativeResponse;
import com.avenuecode.core.service.dao.hibernate.HibernateDao;

import br.com.empresa1.report.dto.backoffice.PedidoReciboDTO;
import br.com.empresa1.report.service.dao.OrderReceiptDao;

@HibernateDao
public class UpdateOrderReceiptNativeCommand extends AbstractHibernateNativeCreateCommand<OrderReceiptDao, PedidoReciboDTO, Long, UpdateOrderReceiptRequest, GenericCreateUpdateNativeResponse<PedidoReciboDTO>> {

    @Override
    protected String createSQL(UpdateOrderReceiptRequest request) {
        StringBuilder sql = new StringBuilder();

        sql.append(" UPDATE REM_RECIBO_EMITIDO RE ");
        sql.append(" SET REM_QTD_REIMPRESSAO = (REM_QTD_REIMPRESSAO + 1), ");
        sql.append(" 	REM_DT_ULTIMA_REIMPRESSAO = SYSDATE ");
        sql.append(" WHERE ");
        sql.append(" 	RE.CID_ID = (SELECT CID_ID FROM ENT_ENTIDADE ENT WHERE ENT.ENT_ID = RE.ENT_ID) ");
        sql.append(" 	AND RE.CID_ID = (SELECT DISTINCT CID_ID FROM REP_RECIBO_PAGAMENTO REP WHERE REP.CID_ID = RE.CID_ID) ");
        sql.append(" 	AND RE.ENT_ID = (SELECT ENT_ID FROM ENT_ENTIDADE ENT WHERE ENT.ENT_ID = RE.ENT_ID) ");
        sql.append(" 	AND ROWNUM < 1000 ");

        if (request.getTipoRecibo() != null) {
            sql.append("   AND ((SELECT REP_ID FROM REP_RECIBO_PAGAMENTO REP WHERE REP.REP_ID = :tipoRecibo) = :tipoRecibo AND RE.REP_ID = :tipoRecibo) ");
        } else {
            sql.append("   AND RE.REP_ID = (SELECT REP_ID FROM REP_RECIBO_PAGAMENTO REP WHERE REP.REP_ID = RE.REP_ID) ");
        }

        if (request.getOrgId() != null) {
            sql.append("   AND RE.ENT_ID = :orgId ");
        }

        if (request.getNumPedido() != null) {
            sql.append("   AND RE.REM_NPEDIDO = :numPedido ");
        }

        if (request.getDataInicio() != null) {
            sql.append("   AND RE.REM_DT_PROCESSAMENTO >= :dataInicio ");
        }

        if (request.getDataFim() != null) {
            sql.append("   AND RE.REM_DT_PROCESSAMENTO - 1 <= :dataFim ");
        }

        return sql.toString();
    }

    @Override
    protected void setQueryParameters(Query query, UpdateOrderReceiptRequest request) {

        if (request.getTipoRecibo() != null) {
            query.setLong("tipoRecibo", request.getTipoRecibo());
        }

        if (request.getOrgId() != null) {
            query.setLong("orgId", request.getOrgId());
        }

        if (request.getNumPedido() != null) {
            query.setLong("numPedido", request.getNumPedido());
        }

        if (request.getDataInicio() != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date dataInicio = formatter.parse(request.getDataInicio());
                query.setDate("dataInicio", dataInicio);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }

        if (request.getDataFim() != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date dataFim = formatter.parse(request.getDataFim());
                query.setDate("dataFim", dataFim);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
    }

}
