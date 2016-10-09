/*
 * ao-appcluster - Application-level clustering tools.
 * Copyright (C) 2011, 2015, 2016  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of ao-appcluster.
 *
 * ao-appcluster is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ao-appcluster is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ao-appcluster.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoindustries.appcluster.imap;

import com.aoindustries.appcluster.AppCluster;
import com.aoindustries.appcluster.AppClusterConfigurationException;
import com.aoindustries.appcluster.AppClusterPropertiesConfiguration;
import com.aoindustries.appcluster.CronResourcePropertiesConfiguration;
import com.aoindustries.appcluster.ResourceNode;
import com.aoindustries.util.AoCollections;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The configuration for an IMAP inbox.
 *
 * @author  AO Industries, Inc.
 */
public class ImapResourcePropertiesConfiguration extends CronResourcePropertiesConfiguration<ImapResource,ImapResourceNode> implements ImapResourceConfiguration {

	protected ImapResourcePropertiesConfiguration(AppClusterPropertiesConfiguration properties, String id) throws AppClusterConfigurationException {
		super(properties, id);
	}

	@Override
	public Set<? extends ImapResourceNodePropertiesConfiguration> getResourceNodeConfigurations() throws AppClusterConfigurationException {
		String resourceId = getId();
		Set<String> nodeIds = properties.getUniqueStrings("appcluster.resource."+id+".nodes", true);
		Set<ImapResourceNodePropertiesConfiguration> resourceNodes = new LinkedHashSet<ImapResourceNodePropertiesConfiguration>(nodeIds.size()*4/3+1);
		for(String nodeId : nodeIds) {
			if(!resourceNodes.add(new ImapResourceNodePropertiesConfiguration(properties, resourceId, nodeId, type))) throw new AssertionError();
		}
		return AoCollections.optimalUnmodifiableSet(resourceNodes);
	}

	@Override
	public ImapResource newResource(AppCluster cluster, Collection<? extends ResourceNode<?,?>> resourceNodes) throws AppClusterConfigurationException {
		return new ImapResource(cluster, this, resourceNodes);
	}
}
