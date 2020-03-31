package com.aoher.service.powermock;

import com.aoher.powermock.Dependency;
import com.aoher.powermock.SystemUnderTest;
import com.aoher.powermock.UtilityClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UtilityClass.class})
@PowerMockIgnore("jdk.internal.reflect.*")
public class PowerMockitoMockingStaticMethodTest {

    @Mock
    Dependency dependencyMock;

    @InjectMocks
    private SystemUnderTest systemUnderTest;

    @Test
    public void powerMockitoMockingAStaticMethodCall() {
        mockStatic(UtilityClass.class);

        when(dependencyMock.retrieveAllStats()).thenReturn(Arrays.asList(1, 2, 3));
        when(UtilityClass.staticMethod(anyLong())).thenReturn(150);

        assertEquals(150, systemUnderTest.methodCallingAStaticMethod());
        verifyStatic(times(1));
        UtilityClass.staticMethod(1 + 2 + 3);
    }
}
