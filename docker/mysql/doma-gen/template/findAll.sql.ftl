--  自動生成のため原則修正禁止!!
SELECT
  /*%expand*/*
FROM
  ${entityDesc.tableName}
WHERE
<#list entityDesc.entityPropertyDescs as property>
<#if property.name == "version" >
<#elseif 0 lte property.name?index_of("Flg") >
/*%if criteria.${property.name}True  */
  ${property.columnName} = true
/*%end*/
/*%if criteria.${property.name}False  */
  ${property.columnName} = false
/*%end*/
<#else>
/*%if criteria.${property.name}Eq != null */
  ${property.columnName} = /* criteria.${property.name}Eq */<#if property.number>1<#elseif property.time>${toTime("12:34:56")}<#elseif property.date>${toDate("2010-01-23")}<#elseif property.timestamp>${toTimestamp("2010-01-23 12:34:56")}<#else>'a'</#if>
/*%end*/
/*%if criteria.${property.name}Ne != null */
  ${property.columnName} != /* criteria.${property.name}Ne */<#if property.number>1<#elseif property.time>${toTime("12:34:56")}<#elseif property.date>${toDate("2010-01-23")}<#elseif property.timestamp>${toTimestamp("2010-01-23 12:34:56")}<#else>'a'</#if>
/*%end*/
/*%if criteria.${property.name}Lt != null */
  ${property.columnName} < /* criteria.${property.name}Lt */<#if property.number>1<#elseif property.time>${toTime("12:34:56")}<#elseif property.date>${toDate("2010-01-23")}<#elseif property.timestamp>${toTimestamp("2010-01-23 12:34:56")}<#else>'a'</#if>
/*%end*/
/*%if criteria.${property.name}Le != null */
  ${property.columnName} <= /* criteria.${property.name}Le */<#if property.number>1<#elseif property.time>${toTime("12:34:56")}<#elseif property.date>${toDate("2010-01-23")}<#elseif property.timestamp>${toTimestamp("2010-01-23 12:34:56")}<#else>'a'</#if>
/*%end*/
/*%if criteria.${property.name}Gt != null */
  ${property.columnName} > /* criteria.${property.name}Lt */<#if property.number>1<#elseif property.time>${toTime("12:34:56")}<#elseif property.date>${toDate("2010-01-23")}<#elseif property.timestamp>${toTimestamp("2010-01-23 12:34:56")}<#else>'a'</#if>
/*%end*/
/*%if criteria.${property.name}Ge != null */
  ${property.columnName} >= /* criteria.${property.name}Le */<#if property.number>1<#elseif property.time>${toTime("12:34:56")}<#elseif property.date>${toDate("2010-01-23")}<#elseif property.timestamp>${toTimestamp("2010-01-23 12:34:56")}<#else>'a'</#if>
/*%end*/
/*%if criteria.${property.name}IsNull  */
  ${property.columnName} IS NULL
/*%end*/
/*%if criteria.${property.name}IsNotNull  */
  ${property.columnName} IS NOT NULL
/*%end*/
<#if (property.date || property.timestamp)>
<#elseif property.number>
/*%if criteria.${property.name}In != null  */
  ${property.columnName} IN /* criteria.${property.name}In */(1,2,3)
/*%end*/
/*%if criteria.${property.name}NotIn != null  */
  ${property.columnName} NOT IN /* criteria.${property.name}NotIn */(1,2,3)
/*%end*/
<#else>
/*%if criteria.${property.name}Like != null  */
  ${property.columnName} LIKE /* @infix(criteria.${property.name}Like) */'smith'
/*%end*/
/*%if criteria.${property.name}NotLike != null  */
  ${property.columnName} NOT LIKE /* @infix(criteria.${property.name}NotLike) */'smith'
/*%end*/
/*%if criteria.${property.name}Starts != null  */
  ${property.columnName} LIKE /* @prefix(criteria.${property.name}Starts) */'smith'
/*%end*/
/*%if criteria.${property.name}NotStarts != null  */
  ${property.columnName} NOT LIKE /* @prefix(criteria.${property.name}NotStarts) */'smith'
/*%end*/
/*%if criteria.${property.name}Ends != null  */
  ${property.columnName} LIKE /* @suffix(criteria.${property.name}Ends) */'smith'
/*%end*/
/*%if criteria.${property.name}NotEnds != null  */
  ${property.columnName} NOT LIKE /* @suffix(criteria.${property.name}NotEnds) */'smith'
/*%end*/
</#if>
</#if>
</#list>
