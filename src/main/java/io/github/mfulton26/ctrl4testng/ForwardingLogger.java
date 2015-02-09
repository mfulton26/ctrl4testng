package io.github.mfulton26.ctrl4testng;

import com.google.common.collect.ForwardingObject;
import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * A logger which forwards all its method calls to another logger. Subclasses should override one or more methods to
 * modify the behavior of the backing logger as desired per the <a href="http://en.wikipedia.org/wiki/Decorator_pattern"
 * >decorator pattern</a>.
 *
 * @author Mark Fulton
 */
abstract class ForwardingLogger extends ForwardingObject implements Logger {

    protected ForwardingLogger() {
    }

    @Override
    protected abstract Logger delegate();

    public String getName() {
        return delegate().getName();
    }

    public void error(Marker marker, String format, Object... arguments) {
        delegate().error(marker, format, arguments);
    }

    public void info(String msg) {
        delegate().info(msg);
    }

    public void error(String format, Object... arguments) {
        delegate().error(format, arguments);
    }

    public void error(String msg, Throwable t) {
        delegate().error(msg, t);
    }

    public boolean isErrorEnabled(Marker marker) {
        return delegate().isErrorEnabled(marker);
    }

    public void debug(Marker marker, String format, Object... arguments) {
        delegate().debug(marker, format, arguments);
    }

    public void error(Marker marker, String format, Object arg1, Object arg2) {
        delegate().error(marker, format, arg1, arg2);
    }

    public void info(String format, Object arg1, Object arg2) {
        delegate().info(format, arg1, arg2);
    }

    public void trace(Marker marker, String msg) {
        delegate().trace(marker, msg);
    }

    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        delegate().debug(marker, format, arg1, arg2);
    }

    public void info(Marker marker, String format, Object arg) {
        delegate().info(marker, format, arg);
    }

    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        delegate().trace(marker, format, arg1, arg2);
    }

    public boolean isErrorEnabled() {
        return delegate().isErrorEnabled();
    }

    public void info(String format, Object... arguments) {
        delegate().info(format, arguments);
    }

    public void info(Marker marker, String format, Object... arguments) {
        delegate().info(marker, format, arguments);
    }

    public void warn(Marker marker, String format, Object... arguments) {
        delegate().warn(marker, format, arguments);
    }

    public void info(Marker marker, String msg) {
        delegate().info(marker, msg);
    }

    public boolean isWarnEnabled() {
        return delegate().isWarnEnabled();
    }

    public void trace(String format, Object... arguments) {
        delegate().trace(format, arguments);
    }

    public void trace(Marker marker, String format, Object... argArray) {
        delegate().trace(marker, format, argArray);
    }

    public void error(Marker marker, String format, Object arg) {
        delegate().error(marker, format, arg);
    }

    public void debug(Marker marker, String msg, Throwable t) {
        delegate().debug(marker, msg, t);
    }

    public void error(String msg) {
        delegate().error(msg);
    }

    public void error(String format, Object arg) {
        delegate().error(format, arg);
    }

    public void error(Marker marker, String msg) {
        delegate().error(marker, msg);
    }

    public void warn(Marker marker, String msg, Throwable t) {
        delegate().warn(marker, msg, t);
    }

    public void trace(String msg) {
        delegate().trace(msg);
    }

    public void trace(Marker marker, String msg, Throwable t) {
        delegate().trace(marker, msg, t);
    }

    public void debug(String format, Object... arguments) {
        delegate().debug(format, arguments);
    }

    public void debug(String format, Object arg1, Object arg2) {
        delegate().debug(format, arg1, arg2);
    }

    public void trace(String msg, Throwable t) {
        delegate().trace(msg, t);
    }

    public void debug(Marker marker, String msg) {
        delegate().debug(marker, msg);
    }

    public void debug(String msg) {
        delegate().debug(msg);
    }

    public boolean isTraceEnabled() {
        return delegate().isTraceEnabled();
    }

    public void debug(Marker marker, String format, Object arg) {
        delegate().debug(marker, format, arg);
    }

    public void warn(String msg) {
        delegate().warn(msg);
    }

    public boolean isWarnEnabled(Marker marker) {
        return delegate().isWarnEnabled(marker);
    }

    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        delegate().warn(marker, format, arg1, arg2);
    }

    public void trace(Marker marker, String format, Object arg) {
        delegate().trace(marker, format, arg);
    }

    public void warn(Marker marker, String format, Object arg) {
        delegate().warn(marker, format, arg);
    }

    public boolean isTraceEnabled(Marker marker) {
        return delegate().isTraceEnabled(marker);
    }

    public void error(String format, Object arg1, Object arg2) {
        delegate().error(format, arg1, arg2);
    }

    public void trace(String format, Object arg) {
        delegate().trace(format, arg);
    }

    public void warn(String format, Object arg) {
        delegate().warn(format, arg);
    }

    public void warn(String msg, Throwable t) {
        delegate().warn(msg, t);
    }

    public boolean isInfoEnabled() {
        return delegate().isInfoEnabled();
    }

    public boolean isDebugEnabled(Marker marker) {
        return delegate().isDebugEnabled(marker);
    }

    public void warn(String format, Object... arguments) {
        delegate().warn(format, arguments);
    }

    public void info(Marker marker, String format, Object arg1, Object arg2) {
        delegate().info(marker, format, arg1, arg2);
    }

    public void debug(String msg, Throwable t) {
        delegate().debug(msg, t);
    }

    public void debug(String format, Object arg) {
        delegate().debug(format, arg);
    }

    public void info(Marker marker, String msg, Throwable t) {
        delegate().info(marker, msg, t);
    }

    public void warn(String format, Object arg1, Object arg2) {
        delegate().warn(format, arg1, arg2);
    }

    public void info(String format, Object arg) {
        delegate().info(format, arg);
    }

    public void error(Marker marker, String msg, Throwable t) {
        delegate().error(marker, msg, t);
    }

    public void warn(Marker marker, String msg) {
        delegate().warn(marker, msg);
    }

    public void trace(String format, Object arg1, Object arg2) {
        delegate().trace(format, arg1, arg2);
    }

    public boolean isInfoEnabled(Marker marker) {
        return delegate().isInfoEnabled(marker);
    }

    public boolean isDebugEnabled() {
        return delegate().isDebugEnabled();
    }

    public void info(String msg, Throwable t) {
        delegate().info(msg, t);
    }

}
