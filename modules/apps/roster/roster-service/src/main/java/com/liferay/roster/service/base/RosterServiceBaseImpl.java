/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.roster.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.roster.model.Roster;
import com.liferay.roster.service.RosterService;
import com.liferay.roster.service.persistence.ClubPersistence;
import com.liferay.roster.service.persistence.RosterMemberPersistence;
import com.liferay.roster.service.persistence.RosterPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the roster remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.roster.service.impl.RosterServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.roster.service.impl.RosterServiceImpl
 * @see com.liferay.roster.service.RosterServiceUtil
 * @generated
 */
public abstract class RosterServiceBaseImpl extends BaseServiceImpl
	implements RosterService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.roster.service.RosterServiceUtil} to access the roster remote service.
	 */

	/**
	 * Returns the club local service.
	 *
	 * @return the club local service
	 */
	public com.liferay.roster.service.ClubLocalService getClubLocalService() {
		return clubLocalService;
	}

	/**
	 * Sets the club local service.
	 *
	 * @param clubLocalService the club local service
	 */
	public void setClubLocalService(
		com.liferay.roster.service.ClubLocalService clubLocalService) {
		this.clubLocalService = clubLocalService;
	}

	/**
	 * Returns the club remote service.
	 *
	 * @return the club remote service
	 */
	public com.liferay.roster.service.ClubService getClubService() {
		return clubService;
	}

	/**
	 * Sets the club remote service.
	 *
	 * @param clubService the club remote service
	 */
	public void setClubService(
		com.liferay.roster.service.ClubService clubService) {
		this.clubService = clubService;
	}

	/**
	 * Returns the club persistence.
	 *
	 * @return the club persistence
	 */
	public ClubPersistence getClubPersistence() {
		return clubPersistence;
	}

	/**
	 * Sets the club persistence.
	 *
	 * @param clubPersistence the club persistence
	 */
	public void setClubPersistence(ClubPersistence clubPersistence) {
		this.clubPersistence = clubPersistence;
	}

	/**
	 * Returns the roster local service.
	 *
	 * @return the roster local service
	 */
	public com.liferay.roster.service.RosterLocalService getRosterLocalService() {
		return rosterLocalService;
	}

	/**
	 * Sets the roster local service.
	 *
	 * @param rosterLocalService the roster local service
	 */
	public void setRosterLocalService(
		com.liferay.roster.service.RosterLocalService rosterLocalService) {
		this.rosterLocalService = rosterLocalService;
	}

	/**
	 * Returns the roster remote service.
	 *
	 * @return the roster remote service
	 */
	public RosterService getRosterService() {
		return rosterService;
	}

	/**
	 * Sets the roster remote service.
	 *
	 * @param rosterService the roster remote service
	 */
	public void setRosterService(RosterService rosterService) {
		this.rosterService = rosterService;
	}

	/**
	 * Returns the roster persistence.
	 *
	 * @return the roster persistence
	 */
	public RosterPersistence getRosterPersistence() {
		return rosterPersistence;
	}

	/**
	 * Sets the roster persistence.
	 *
	 * @param rosterPersistence the roster persistence
	 */
	public void setRosterPersistence(RosterPersistence rosterPersistence) {
		this.rosterPersistence = rosterPersistence;
	}

	/**
	 * Returns the roster member local service.
	 *
	 * @return the roster member local service
	 */
	public com.liferay.roster.service.RosterMemberLocalService getRosterMemberLocalService() {
		return rosterMemberLocalService;
	}

	/**
	 * Sets the roster member local service.
	 *
	 * @param rosterMemberLocalService the roster member local service
	 */
	public void setRosterMemberLocalService(
		com.liferay.roster.service.RosterMemberLocalService rosterMemberLocalService) {
		this.rosterMemberLocalService = rosterMemberLocalService;
	}

	/**
	 * Returns the roster member remote service.
	 *
	 * @return the roster member remote service
	 */
	public com.liferay.roster.service.RosterMemberService getRosterMemberService() {
		return rosterMemberService;
	}

	/**
	 * Sets the roster member remote service.
	 *
	 * @param rosterMemberService the roster member remote service
	 */
	public void setRosterMemberService(
		com.liferay.roster.service.RosterMemberService rosterMemberService) {
		this.rosterMemberService = rosterMemberService;
	}

	/**
	 * Returns the roster member persistence.
	 *
	 * @return the roster member persistence
	 */
	public RosterMemberPersistence getRosterMemberPersistence() {
		return rosterMemberPersistence;
	}

	/**
	 * Sets the roster member persistence.
	 *
	 * @param rosterMemberPersistence the roster member persistence
	 */
	public void setRosterMemberPersistence(
		RosterMemberPersistence rosterMemberPersistence) {
		this.rosterMemberPersistence = rosterMemberPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return RosterService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Roster.class;
	}

	protected String getModelClassName() {
		return Roster.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = rosterPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.roster.service.ClubLocalService.class)
	protected com.liferay.roster.service.ClubLocalService clubLocalService;
	@BeanReference(type = com.liferay.roster.service.ClubService.class)
	protected com.liferay.roster.service.ClubService clubService;
	@BeanReference(type = ClubPersistence.class)
	protected ClubPersistence clubPersistence;
	@BeanReference(type = com.liferay.roster.service.RosterLocalService.class)
	protected com.liferay.roster.service.RosterLocalService rosterLocalService;
	@BeanReference(type = com.liferay.roster.service.RosterService.class)
	protected RosterService rosterService;
	@BeanReference(type = RosterPersistence.class)
	protected RosterPersistence rosterPersistence;
	@BeanReference(type = com.liferay.roster.service.RosterMemberLocalService.class)
	protected com.liferay.roster.service.RosterMemberLocalService rosterMemberLocalService;
	@BeanReference(type = com.liferay.roster.service.RosterMemberService.class)
	protected com.liferay.roster.service.RosterMemberService rosterMemberService;
	@BeanReference(type = RosterMemberPersistence.class)
	protected RosterMemberPersistence rosterMemberPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}