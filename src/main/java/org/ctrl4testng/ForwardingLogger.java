package org.ctrl4testng;

import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * A logger which forwards all its method calls to another logger. Subclasses should override one or more methods to
 * modify the behavior of the backing list as desired per the <a href="http://en.wikipedia.org/wiki/Decorator_pattern">
 * decorator pattern</a>.
 *
 * @author Mark Fulton
 */
abstract class ForwardingLogger implements Logger {

    protected ForwardingLogger() {
    }

    protected abstract Logger getLogger();

    public String getName() {
        return getLogger().getName();
    }

    public void error(Marker marker, String format, Object... arguments) {
        getLogger().error(marker, format, arguments);
    }

    public void info(String msg) {
        getLogger().info(msg);
    }

    public void error(String format, Object... arguments) {
        getLogger().error(format, arguments);
    }

    public void error(String msg, Throwable t) {
        getLogger().error(msg, t);
    }

    public boolean isErrorEnabled(Marker marker) {
        return getLogger().isErrorEnabled(marker);
    }

    public void debug(Marker marker, String format, Object... arguments) {
        getLogger().debug(marker, format, arguments);
    }

    public void error(Marker marker, String format, Object arg1, Object arg2) {
        getLogger().error(marker, format, arg1, arg2);
    }

    public void info(String format, Object arg1, Object arg2) {
        getLogger().info(format, arg1, arg2);
    }

    public void trace(Marker marker, String msg) {
        getLogger().trace(marker, msg);
    }

    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        getLogger().debug(marker, format, arg1, arg2);
    }

    public void info(Marker marker, String format, Object arg) {
        getLogger().info(marker, format, arg);
    }

    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        getLogger().trace(marker, format, arg1, arg2);
    }

    public boolean isErrorEnabled() {
        return getLogger().isErrorEnabled();
    }

    public void info(String format, Object... arguments) {
        getLogger().info(format, arguments);
    }

    public void info(Marker marker, String format, Object... arguments) {
        getLogger().info(marker, format, arguments);
    }

    public void warn(Marker marker, String format, Object... arguments) {
        getLogger().warn(marker, format, arguments);
    }

    public void info(Marker marker, String msg) {
        getLogger().info(marker, msg);
    }

    public boolean isWarnEnabled() {
        return getLogger().isWarnEnabled();
    }

    public void trace(String format, Object... arguments) {
        getLogger().trace(format, arguments);
    }

    public void trace(Marker marker, String format, Object... argArray) {
        getLogger().trace(marker, format, argArray);
    }

    public void error(Marker marker, String format, Object arg) {
        getLogger().error(marker, format, arg);
    }

    public void debug(Marker marker, String msg, Throwable t) {
        getLogger().debug(marker, msg, t);
    }

    public void error(String msg) {
        getLogger().error(msg);
    }

    public void error(String format, Object arg) {
        getLogger().error(format, arg);
    }

    public void error(Marker marker, String msg) {
        getLogger().error(marker, msg);
    }

    public void warn(Marker marker, String msg, Throwable t) {
        getLogger().warn(marker, msg, t);
    }

    public void trace(String msg) {
        getLogger().trace(msg);
    }

    public void trace(Marker marker, String msg, Throwable t) {
        getLogger().trace(marker, msg, t);
    }

    public void debug(String format, Object... arguments) {
        getLogger().debug(format, arguments);
    }

    public void debug(String format, Object arg1, Object arg2) {
        getLogger().debug(format, arg1, arg2);
    }

    public void trace(String msg, Throwable t) {
        getLogger().trace(msg, t);
    }

    public void debug(Marker marker, String msg) {
        getLogger().debug(marker, msg);
    }

    public void debug(String msg) {
        getLogger().debug(msg);
    }

    public boolean isTraceEnabled() {
        return getLogger().isTraceEnabled();
    }

    public void debug(Marker marker, String format, Object arg) {
        getLogger().debug(marker, format, arg);
    }

    public void warn(String msg) {
        getLogger().warn(msg);
    }

    public boolean isWarnEnabled(Marker marker) {
        return getLogger().isWarnEnabled(marker);
    }

    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        getLogger().warn(marker, format, arg1, arg2);
    }

    public void trace(Marker marker, String format, Object arg) {
        getLogger().trace(marker, format, arg);
    }

    public void warn(Marker marker, String format, Object arg) {
        getLogger().warn(marker, format, arg);
    }

    public boolean isTraceEnabled(Marker marker) {
        return getLogger().isTraceEnabled(marker);
    }

    public void error(String format, Object arg1, Object arg2) {
        getLogger().error(format, arg1, arg2);
    }

    public void trace(String format, Object arg) {
        getLogger().trace(format, arg);
    }

    public void warn(String format, Object arg) {
        getLogger().warn(format, arg);
    }

    public void warn(String msg, Throwable t) {
        getLogger().warn(msg, t);
    }

    public boolean isInfoEnabled() {
        return getLogger().isInfoEnabled();
    }

    public boolean isDebugEnabled(Marker marker) {
        return getLogger().isDebugEnabled(marker);
    }

    public void warn(String format, Object... arguments) {
        getLogger().warn(format, arguments);
    }

    public void info(Marker marker, String format, Object arg1, Object arg2) {
        getLogger().info(marker, format, arg1, arg2);
    }

    public void debug(String msg, Throwable t) {
        getLogger().debug(msg, t);
    }

    public void debug(String format, Object arg) {
        getLogger().debug(format, arg);
    }

    public void info(Marker marker, String msg, Throwable t) {
        getLogger().info(marker, msg, t);
    }

    public void warn(String format, Object arg1, Object arg2) {
        getLogger().warn(format, arg1, arg2);
    }

    public void info(String format, Object arg) {
        getLogger().info(format, arg);
    }

    public void error(Marker marker, String msg, Throwable t) {
        getLogger().error(marker, msg, t);
    }

    public void warn(Marker marker, String msg) {
        getLogger().warn(marker, msg);
    }

    public void trace(String format, Object arg1, Object arg2) {
        getLogger().trace(format, arg1, arg2);
    }

    public boolean isInfoEnabled(Marker marker) {
        return getLogger().isInfoEnabled(marker);
    }

    public boolean isDebugEnabled() {
        return getLogger().isDebugEnabled();
    }

    public void info(String msg, Throwable t) {
        getLogger().info(msg, t);
    }

}
