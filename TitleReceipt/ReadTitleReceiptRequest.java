package br.com.empresa1.report.service.command.read;

import com.avenuecode.core.service.command.request.AbstractIdentifiedRequest;
import com.avenuecode.core.service.command.request.RequestProcessing;

import br.com.empresa1.report.service.command.response.TitleReceiptResponse;

@RequestProcessing(command = ReadTitleReceiptCommand.class, response = TitleReceiptResponse.class)
public class ReadTitleReceiptRequest extends AbstractIdentifiedRequest<Long> {
	private static final long serialVersionUID = -4220615863598324402L;
}
