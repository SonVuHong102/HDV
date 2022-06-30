package demo.dto.request.wallet;

import demo.dto.request.IRequestData;
import demo.model.Wallet;
import lombok.Data;

@Data
public class WalletReq extends Wallet implements IRequestData {
}
