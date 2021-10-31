/*
 * ao-appcluster-imap - Application-level clustering tools for IMAP account replication.
 * Copyright (C) 2011, 2016, 2021  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of ao-appcluster-imap.
 *
 * ao-appcluster-imap is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ao-appcluster-imap is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ao-appcluster-imap.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.aoapps.appcluster.imap;

import com.aoapps.appcluster.AppCluster;
import com.aoapps.appcluster.AppClusterConfigurationException;
import com.aoapps.appcluster.CronResourceConfiguration;
import com.aoapps.appcluster.ResourceNode;
import java.util.Collection;
import java.util.Set;

/**
 * The configuration for an IMAP inbox.
 *
 * @author  AO Industries, Inc.
 */
public interface ImapResourceConfiguration extends CronResourceConfiguration<ImapResource, ImapResourceNode> {

	@Override
	Set<? extends ImapResourceNodeConfiguration> getResourceNodeConfigurations() throws AppClusterConfigurationException;

	@Override
	ImapResource newResource(AppCluster cluster, Collection<? extends ResourceNode<?, ?>> resourceNodes) throws AppClusterConfigurationException;
}
