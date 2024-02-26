package br.com.empresa1.report.service.command.read;

import com.avenuecode.core.service.command.request.AbstractIdentifiedRequest;
import com.avenuecode.core.service.command.request.RequestProcessing;

import br.com.empresa1.report.service.command.response.OrderReceiptResponse;

@RequestProcessing(command = ReadOrderReceiptCommand.class, response = OrderReceiptResponse.class)
public class ReadOrderReceiptRequest extends AbstractIdentifiedRequest<Long> {
    private static final long serialVersionUID = -8845615863598324402L;
}
