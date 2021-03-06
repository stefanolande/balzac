/*
 * Copyright 2017 Nicola Atzei
 */
package it.unica.tcs.xsemantics;

import com.google.inject.Inject;

import it.unica.tcs.bitcoinTM.Transaction;
import it.unica.tcs.bitcoinTM.TransactionLiteral;
import it.unica.tcs.compiler.TransactionCompiler;
import it.unica.tcs.lib.ITransactionBuilder;

/**
 * This class solves maven-build problems of interpreter.xsemantics
 */
class TransactionCompilerDelegate {

    @Inject private TransactionCompiler compiler;

    public ITransactionBuilder compileTransaction(TransactionLiteral tx) {
        return compiler.compileTransaction(tx);
    }

    public ITransactionBuilder compileTransaction(Transaction tx, Rho rho) {
        return compiler.compileTransaction(tx, rho);
    }
}
