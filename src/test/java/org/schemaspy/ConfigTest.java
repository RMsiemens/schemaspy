package org.schemaspy;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wkasa on 2017-03-04.
 */
public class ConfigTest extends TestCase {

    @Test
    public void testConfig() throws Exception {
        String[] args = {"-t", "mssql05", "-schemas", "dbo, sys", "-h"};

        Config config = new Config(args);
        Assert.assertEquals(2, config.getSchemas().size());
        Assert.assertTrue(config.isHelpRequired());
        Assert.assertFalse(config.isDbHelpRequired());
        assertThat(config.getDbType()).isEqualToIgnoringCase("mssql05");
    }

    @Test
    public void testLoadJars() {
        Config config = new Config("-loadjars", "true");
        assertThat(config.isLoadJDBCJarsEnabled()).isTrue();
    }

}