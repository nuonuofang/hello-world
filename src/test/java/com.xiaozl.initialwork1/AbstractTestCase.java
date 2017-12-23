package com.xiaozl.initialwork1;

import com.xiaozl.initialwork1.entity.User;
import com.xiaozl.initialwork1.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

import java.util.List;

/**
 * @author xiaozl
 * @date 2017/11/20
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring*.xml"})
public abstract class AbstractTestCase extends TestCase {

}
