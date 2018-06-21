package org.itxtech.daedalus.provider;

import android.os.ParcelFileDescriptor;
import org.itxtech.daedalus.Daedalus;
import org.itxtech.daedalus.service.DaedalusVpnService;

/**
 * Daedalus Project
 *
 * @author iTX Technologies
 * @link https://itxtech.org
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 */
public class ProviderPicker {
    public static final int DNS_QUERY_METHOD_UDP = 0;
    public static final int DNS_QUERY_METHOD_TCP = 1;
    public static final int DNS_QUERY_METHOD_TLS = 2;
    public static final int DNS_QUERY_METHOD_HTTPS_IETF = 3;
    public static final int DNS_QUERY_METHOD_HTTPS_JSON = 4;

    public static Provider getProvider(ParcelFileDescriptor descriptor, DaedalusVpnService service) {
        switch (Integer.valueOf(Daedalus.getPrefs().getString("settings_dns_query_method", "0"))) {
            case DNS_QUERY_METHOD_UDP:
                return new UdpProvider(descriptor, service);
            case DNS_QUERY_METHOD_TCP:
                return new TcpProvider(descriptor, service);
            case DNS_QUERY_METHOD_HTTPS_IETF:
                return new HttpsIetfProvider(descriptor, service);
            case DNS_QUERY_METHOD_HTTPS_JSON:
                break;
            case DNS_QUERY_METHOD_TLS:
                break;
        }
        return new UdpProvider(descriptor, service);
    }
}
