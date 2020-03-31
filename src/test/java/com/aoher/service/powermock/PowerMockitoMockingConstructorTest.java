package com.aoher.service.powermock;

import com.aoher.powermock.Dependency;
import com.aoher.powermock.SystemUnderTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ SystemUnderTest.class })
@PowerMockIgnore("jdk.internal.reflect.*")
public class PowerMockitoMockingConstructorTest {

    private static final int SOME_DUMMY_SIZE = 100;

    @Mock
    private Dependency dependencyMock;

    @InjectMocks
    private SystemUnderTest systemUnderTest;

    @Test
    public void powerMockitoMockingAConstructor() throws Exception {
        ArrayList<String> mockList = mock(ArrayList.class);

        stub(mockList.size()).toReturn(SOME_DUMMY_SIZE);
        whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);

        int size = systemUnderTest.methodUsingAnArrayListConstructor();

        assertEquals(SOME_DUMMY_SIZE, size);
    }
}
