package nl.casparderksen.util.rest.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import java.util.NoSuchElementException;

import static nl.casparderksen.util.rest.Headers.REASON;

/**
 * Maps {@link NoSuchElementException} to not found response.
 */
@Provider
public class NoSuchElementExceptionMapper implements ExceptionMapper<NoSuchElementException> {

    @Override
    public Response toResponse(NoSuchElementException exception) {
        String reason = exception.getMessage();
        return Response.status(Response.Status.NOT_FOUND).header(REASON, reason).build();
    }
}