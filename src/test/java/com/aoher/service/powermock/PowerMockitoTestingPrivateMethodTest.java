package com.aoher.service.powermock;

import com.aoher.powermock.Dependency;
import com.aoher.powermock.SystemUnderTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("jdk.internal.reflect.*")
public class PowerMockitoTestingPrivateMethodTest {

    @Mock
    private Dependency dependencyMock;

    @InjectMocks
    private SystemUnderTest systemUnderTest;

    @Test
    public void powerMockitoCallingAPrivateMethod() throws Exception {
        when(dependencyMock.retrieveAllStats()).thenReturn(Arrays.asList(1, 2, 3));

        long value = (Long) Whitebox.invokeMethod(systemUnderTest,
                "privateMethodUnderTest");

        assertEquals(6, value);
    }
}
