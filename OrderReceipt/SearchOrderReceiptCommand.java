package br.com.empresa1.report.service.command.search;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.avenuecode.core.service.command.hibernate.AbstractHibernateNativeQuerySearchCommand;
import com.avenuecode.core.service.command.hibernate.HibernateCommand;

import br.com.empresa1.report.dto.backoffice.PedidoReciboDTO;
import br.com.empresa1.report.service.command.response.OrderReceiptSearchResponse;

@HibernateCommand
public class SearchOrderReceiptCommand extends
    AbstractHibernateNativeQuerySearchCommand<PedidoReciboDTO, Long, SearchOrderReceiptRequest, OrderReceiptSearchResponse> {
    @Override
    protected String createSQL(SearchOrderReceiptRequest request) {
        StringBuilder sql = new StringBuilder();

        sql.append(" SELECT ");
        sql.append("   RE.REM_ID, ");
        sql.append("   ENT.ENT_NOME, ");
        sql.append("   RE.REM_NPEDIDO, ");
        sql.append(
            "   'R$ ' || TO_CHAR(RE.REM_VALOR_RECIBO, 'FM999,999,999,999,999,999,999.00') AS REM_VALOR_RECIBO, ");
        sql.append("   TO_CHAR(RE.REM_DT_PROCESSAMENTO, 'DD/MM/YYYY') REM_DT_PROCESSAMENTO, ");
        sql.append("   TO_CHAR(RE.REM_DT_ULTIMA_REIMPRESSAO, 'DD/MM/YYYY') REM_DT_ULTIMA_REIMPRESSAO, ");
        sql.append("   RE.REM_QTD_REIMPRESSAO ");
        sql.append(" FROM ");
        sql.append("   REM_RECIBO_EMITIDO RE, ");
        sql.append("   REP_RECIBO_PAGAMENTO REP, ");
        sql.append("   ENT_ENTIDADE ENT ");
        sql.append(" WHERE ");
        sql.append("   ENT.CID_ID = RE.CID_ID ");
        sql.append("   AND RE.CID_ID = REP.CID_ID ");
        sql.append("   AND ENT.ENT_ID = RE.ENT_ID ");
        sql.append("   AND ROWNUM < 1000 ");

        if (request.getTipoRecibo() != null) {
            sql.append("   AND (REP.REP_ID = :tipoRecibo AND RE.REP_ID = :tipoRecibo)");
        } else {
            sql.append("   AND RE.REP_ID = REP.REP_ID ");
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

        sql.append("   ORDER BY ENT.ENT_ID DESC");

        return sql.toString();
    }

    @Override
    protected void setQueryParameters(Query query, SearchOrderReceiptRequest request) {

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

    @Override
    protected List<PedidoReciboDTO> convertResultToObject(List<Object> results) {

        List<PedidoReciboDTO> userResult = new ArrayList<>();

        for (Object resultObj : results) {
            Object[] result = (Object[]) resultObj;

            PedidoReciboDTO dto = new PedidoReciboDTO();

            dto.setId(((BigDecimal) result[0]).longValue());
            dto.setNome((String) result[1]);
            dto.setNumPedido(((BigDecimal) result[2]).longValue());
            dto.setValorPedido((String) result[3]);
            dto.setDataProcessamento((String) result[4]);
            dto.setDataUltimaReimpressao((String) result[5]);
            dto.setQtdReimpressao(((BigDecimal) result[6]).longValue());

            userResult.add(dto);
        }
        return userResult;
    }

}
