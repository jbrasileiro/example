package org.pumpkin.ex4j.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * reference https://eclipse.org/aspectj/doc/next/progguide/index.html
 * 
 * @author https://github.com/jbrasileiro
 */
public aspect LoggingAOP {

    private static final Logger LOG = LogManager.getLogger(LoggingAOP.class);

    Object around() : execution(public * *(..)) {
        boolean log = LOG.isInfoEnabled();
        if (log) {
            LOG.info("EXECUTING : ".concat(thisJoinPoint.getSignature().toString()));
        }
        Object result = proceed();
        return result;
    }

    Object around() : execution(* *(..)) {
        boolean log = !LOG.isTraceEnabled();
        if (log) {
            LOG.debug("EXECUTING : ".concat(thisJoinPoint.getSignature().toString()));
            Object[] arguments = thisJoinPoint.getArgs();
            for (Object argument : arguments) {
                int index = 1;
                if (argument != null) {
                    String clazz = argument.getClass().getSimpleName();
                    String message = "Argument#%s of type %s and value %s.";
                    LOG.debug(String.format(message, index, clazz, argument));
                    index = index + 1;
                }
            }
        }
        Object result = proceed();
        if (log) {
            LOG.debug("PROCESSED :".concat(result.toString()));
        }
        return result;
    }
}
