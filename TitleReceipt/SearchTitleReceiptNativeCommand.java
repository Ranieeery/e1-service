package br.com.empresa1.report.service.command.search;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;

import com.avenuecode.core.service.command.hibernate.AbstractHibernateNativeQuerySearchCommand;
import com.avenuecode.core.service.command.hibernate.HibernateCommand;

import br.com.empresa1.report.dto.backoffice.TituloReciboDTO;
import br.com.empresa1.report.service.command.response.TitleReceiptSearchResponse;

@HibernateCommand
public class SearchTitleReceiptNativeCommand extends
		AbstractHibernateNativeQuerySearchCommand<TituloReciboDTO, Long, SearchTitleReceiptRequest, TitleReceiptSearchResponse> {

	protected String createSQL(SearchTitleReceiptRequest request) {
		StringBuilder sql = new StringBuilder("");
		sql.append(" SELECT DISTINCT  ");
		sql.append("   RP.REP_ID AS Id, ");
		sql.append("   RP.REP_TITULO_RECIBO AS Nome ");
		sql.append(" FROM REP_RECIBO_PAGAMENTO RP, ");
		sql.append(" REM_RECIBO_EMITIDO RE ");
		sql.append(" WHERE 1=1 ");
		sql.append(" AND RP.CID_ID = RE.CID_ID (+) ");

		if (request.getId() != null) {
            String idString = request.getId().toString();
            int idLength = idString.length();
            if (idLength > 0 && idLength < 4) {
                sql.append("AND RP.REP_ID LIKE '%' || :REP_ID || '%' AND RP.REP_ID >= 0 AND RP.REP_ID < 9999 ");
            } else if (idLength >= 4 && idLength <= 5) {
                sql.append("AND RP.REP_ID LIKE '%' || :REP_ID || '%' AND RP.REP_ID < 999999 ");
            } else if (idLength > 5 && idLength <= 7) {
                sql.append("AND RP.REP_ID LIKE '%' || :REP_ID || '%' AND RP.REP_ID < 9999999 ");
            }
        }

        if (StringUtils.isNotBlank(request.getNome())) {
            int nomeLength = request.getNome().length();
            if (nomeLength > 0 && nomeLength < 2) {
                sql.append("AND RP.REP_ID  >= 0 AND RP.REP_ID <= 9999 ");
                sql.append("AND UPPER(RP.REP_TITULO_RECIBO) LIKE '%' || UPPER(:nome) || '%' ");
            } else if (nomeLength >= 2 && nomeLength <= 5) {
                sql.append("AND UPPER(RP.REP_TITULO_RECIBO) LIKE '%' || UPPER(:nome) || '%' AND RP.REP_ID < 999999 ");
            } else if (nomeLength > 5 && nomeLength <= 7) {
                sql.append("AND UPPER(RP.REP_TITULO_RECIBO) LIKE '%' || UPPER(:nome) || '%' AND RP.REP_ID < 9999999 ");
            }
        }
		sql.append("ORDER BY RP.REP_ID ASC");

		return sql.toString();
	}

	@Override
	protected void setQueryParameters(Query query, SearchTitleReceiptRequest request) {
		if (request.getId() != null) {
			query.setParameter("USU_ID", request.getId());
		}

		if (StringUtils.isNotBlank(request.getNome())) {
			query.setParameter("nome", request.getNome());
		}
	}

	@Override
	protected List<TituloReciboDTO> convertResultToObject(List<Object> results) {
		List<TituloReciboDTO> userResult = new ArrayList<>();
		for (Object resultObj : results) {
			Object[] result = (Object[]) resultObj;

			TituloReciboDTO tituloReciboDTO = new TituloReciboDTO();
			tituloReciboDTO.setId(((BigDecimal) result[0]).longValue());
			tituloReciboDTO.setNome((String) result[1]);

			userResult.add(tituloReciboDTO);
		}
		return userResult;
	}
}