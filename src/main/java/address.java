
Package ca.bell.tv.onevu2.domain.service;

import java.util.Set;

import org.springframework.stereotype.Component;

import ca.bell.tv.onevu2.domain.model.Onevu2Order;
import ca.bell.tv.onevu2.domain.model.Onevu2OrderAccount;
import ca.bell.tv.onevu2.domain.model.Onevu2OrderSubsAddress;

@Component("addressUtil")
public class AddressUtil {

    public Onevu2OrderSubsAddress getAddressByAddressType(Onevu2Order order, String addressType) {
        Onevu2OrderAccount orderAccount = order.getOnevu2OrderAccount();
        Onevu2OrderSubsAddress address = null;
        Set<Onevu2OrderSubsAddress> onevu2OrderSubsAddresses = orderAccount.getOnevu2OrderSubsAddresses();
        // extract addresses from order
        if (onevu2OrderSubsAddresses != null) {
            for (Onevu2OrderSubsAddress onevu2OrderSubsAddress : onevu2OrderSubsAddresses) {
                if (addressType.equalsIgnoreCase(onevu2OrderSubsAddress.getOnevu2AddressType().getAdresTypeCd())) {
                    address = onevu2OrderSubsAddress;
                }
            }
        }
        return address;
    }
}
