/*
 * Copyright 2017 Nicola Atzei
 */

package it.unica.tcs.xsemantics;

import java.util.Map.Entry;

import it.unica.tcs.bitcoinTM.AddressType;
import it.unica.tcs.bitcoinTM.BooleanLiteral;
import it.unica.tcs.bitcoinTM.BooleanType;
import it.unica.tcs.bitcoinTM.HashType;
import it.unica.tcs.bitcoinTM.IntType;
import it.unica.tcs.bitcoinTM.KeyType;
import it.unica.tcs.bitcoinTM.Parameter;
import it.unica.tcs.bitcoinTM.PubkeyType;
import it.unica.tcs.bitcoinTM.Reference;
import it.unica.tcs.bitcoinTM.SignatureType;
import it.unica.tcs.bitcoinTM.StringLiteral;
import it.unica.tcs.bitcoinTM.StringType;
import it.unica.tcs.bitcoinTM.TransactionType;
import it.unica.tcs.bitcoinTM.Type;
import it.unica.tcs.bitcoinTM.TypeVariable;
import it.xsemantics.runtime.StringRepresentation;

public class BitcoinTMStringRepresentation extends StringRepresentation {


    public String stringRep(BooleanLiteral intConstant) {
        return intConstant.isTrue()? "true" : "false";
    }

    public String stringRep(StringLiteral stringConstant) {
        return "'" + stringConstant.getValue() + "'";
    }

    public String stringRep(Parameter parameter) {
        return parameter.getName()
                + ((parameter.getType()) != null ? " : "
                        + string(parameter.getType()) : "");
    }

    public String stringRep(Reference ref) {
        return stringRep(ref.getRef());
    }

    public String stringRep(TypeSubstitutions substitutions) {
        return "subst{" + stringIterable(substitutions.getSubstitutions())
                + "}";
    }

    public String stringRep(Entry<String, Type> entry) {
        return string(entry.getKey()) + "=" + string(entry.getValue());
    }

    public String stringRep(Type type) {
        if (type instanceof IntType) {
            return ((IntType) type).getValue().getLiteral();
        }
        else if (type instanceof StringType) {
            return ((StringType) type).getValue().getLiteral();
        }
        else if (type instanceof BooleanType) {
            return ((BooleanType) type).getValue().getLiteral();
        }
        else if (type instanceof SignatureType) {
            return ((SignatureType) type).getValue().getLiteral();
        }
        else if (type instanceof TransactionType) {
            return ((TransactionType) type).getValue().getLiteral();
        }
        else if (type instanceof KeyType) {
            return ((KeyType) type).getValue().getLiteral();
        }
        else if (type instanceof HashType) {
            return ((HashType) type).getValue().getLiteral();
        }
        else if (type instanceof AddressType) {
            return ((AddressType) type).getValue().getLiteral();
        }
        else if (type instanceof PubkeyType) {
            return ((PubkeyType) type).getValue().getLiteral();
        }
        else if (type instanceof TypeVariable) {
            return ((TypeVariable) type).getValue();
        }
        else return "unknown";
    }
}
