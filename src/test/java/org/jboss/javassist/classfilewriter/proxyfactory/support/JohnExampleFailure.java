/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.javassist.classfilewriter.proxyfactory.support;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.annotation.Resources;

import org.jboss.javassist.classfilewriter.proxyfactory.support.annotations.Interceptors;
import org.jboss.javassist.classfilewriter.proxyfactory.support.annotations.ManagedBean;

/**
 * 
 * @author <a href="kabir.khan@jboss.com">Kabir Khan</a>
 * @version $Revision: 1.1 $
 */
@ManagedBean("TestBeanWithInjection")
@Resources({
    @Resource(name="bar", type=ParentClass.class, mappedName="TestBean")
})
@Resource(name="foo", type=ParentClass.class, mappedName="TestBean")
@Interceptors({ParentClass.class})
public class JohnExampleFailure implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Resource private ParentClass other;

    @PostConstruct
    private void printMessage() {
        System.out.println("Test manage bean started: " + other);
    }

    public ParentClass getOther() {
        return other;
    }
}