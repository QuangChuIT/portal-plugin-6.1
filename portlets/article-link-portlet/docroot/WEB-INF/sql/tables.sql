create table ArticleLinkEntry (
	entryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	publishDate DATE null,
	title VARCHAR(75) null,
	link VARCHAR(75) null,
	description VARCHAR(75) null,
	status BOOLEAN,
	urlTitle VARCHAR(75) null
);