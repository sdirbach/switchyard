package org.switchyard.common.camel;

import static org.jboss.logging.Logger.Level.WARN;

import org.jboss.logging.Logger;

import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageLogger;
/**
 * <p/>
 * This file is using the subset 13200-13399 for logger messages.
 * <p/>
 *
 */
@MessageLogger(projectCode = "SWITCHYARD")
public interface CommonCamelLogger {
    /**
     * Default root logger.
     */
    CommonCamelLogger ROOT_LOGGER = Logger.getMessageLogger(CommonCamelLogger.class, CommonCamelLogger.class.getPackage().getName());

    /**
     * cdiNotDetected method definition.
     */
    @LogMessage(level = WARN) 
    @Message(id = 13200, value="CDI environment not detected, disabling Camel CDI integration")
    void cdiNotDetected();

}
