/*
 * Copyright 2018 Nicola Atzei
 */

package it.unica.tcs.lib.model;

import java.util.Arrays;

import org.bitcoinj.core.LegacyAddress;
import org.bitcoinj.core.NetworkParameters;

import it.unica.tcs.lib.utils.BitcoinUtils;

class AddressImpl implements Address {
    
    private final byte[] address;
    protected final NetworkParameters params;

    AddressImpl(byte[] address, NetworkParameters params) {
        this.address = address;
        this.params = params;
    }

    @Override
    public NetworkParameters getNetworkParameters() {
    	return params;
    }

    @Override
    public byte[] getAddressByte() {
        return address;
    }

    @Override
    public String getAddressWif() {
        return LegacyAddress.fromPubKeyHash(params, address).toBase58();
    }

    @Override
    public String getAddressByteString() {
        return BitcoinUtils.encode(address);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(address);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AddressImpl other = (AddressImpl) obj;
        if (!Arrays.equals(address, other.address))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return getAddressWif();
    }
}