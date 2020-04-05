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
  and ${property.columnName} = true
/*%end*/
/*%if criteria.${property.name}False  */
  and ${property.columnName} = false
/*%end*/
<#else>
/*%if criteria.${property.name}Eq != null */
  and ${property.columnName} = /* criteria.${property.name}Eq */<#if property.number>1<#elseif property.time>${toTime("12:34:56")}<#elseif property.date>${toDate("2010-01-23")}<#elseif property.timestamp>${toTimestamp("2010-01-23 12:34:56")}<#else>'a'</#if>
/*%end*/
/*%if criteria.${property.name}Ne != null */
  and ${property.columnName} != /* criteria.${property.name}Ne */<#if property.number>1<#elseif property.time>${toTime("12:34:56")}<#elseif property.date>${toDate("2010-01-23")}<#elseif property.timestamp>${toTimestamp("2010-01-23 12:34:56")}<#else>'a'</#if>
/*%end*/
/*%if criteria.${property.name}Lt != null */
  and ${property.columnName} < /* criteria.${property.name}Lt */<#if property.number>1<#elseif property.time>${toTime("12:34:56")}<#elseif property.date>${toDate("2010-01-23")}<#elseif property.timestamp>${toTimestamp("2010-01-23 12:34:56")}<#else>'a'</#if>
/*%end*/
/*%if criteria.${property.name}Le != null */
  and ${property.columnName} <= /* criteria.${property.name}Le */<#if property.number>1<#elseif property.time>${toTime("12:34:56")}<#elseif property.date>${toDate("2010-01-23")}<#elseif property.timestamp>${toTimestamp("2010-01-23 12:34:56")}<#else>'a'</#if>
/*%end*/
/*%if criteria.${property.name}Gt != null */
  and ${property.columnName} > /* criteria.${property.name}Gt */<#if property.number>1<#elseif property.time>${toTime("12:34:56")}<#elseif property.date>${toDate("2010-01-23")}<#elseif property.timestamp>${toTimestamp("2010-01-23 12:34:56")}<#else>'a'</#if>
/*%end*/
/*%if criteria.${property.name}Ge != null */
  and ${property.columnName} >= /* criteria.${property.name}Ge */<#if property.number>1<#elseif property.time>${toTime("12:34:56")}<#elseif property.date>${toDate("2010-01-23")}<#elseif property.timestamp>${toTimestamp("2010-01-23 12:34:56")}<#else>'a'</#if>
/*%end*/
/*%if criteria.${property.name}IsNull  */
  and ${property.columnName} IS NULL
/*%end*/
/*%if criteria.${property.name}IsNotNull  */
  and ${property.columnName} IS NOT NULL
/*%end*/
<#if (property.date || property.timestamp)>
<#elseif property.number>
/*%if criteria.${property.name}In != null  */
  and ${property.columnName} IN /* criteria.${property.name}In */(1,2,3)
/*%end*/
/*%if criteria.${property.name}NotIn != null  */
  and ${property.columnName} NOT IN /* criteria.${property.name}NotIn */(1,2,3)
/*%end*/
<#else>
/*%if criteria.${property.name}Like != null  */
  and ${property.columnName} LIKE /* @infix(criteria.${property.name}Like) */'smith'
/*%end*/
/*%if criteria.${property.name}NotLike != null  */
  and ${property.columnName} NOT LIKE /* @infix(criteria.${property.name}NotLike) */'smith'
/*%end*/
/*%if criteria.${property.name}Starts != null  */
  and ${property.columnName} LIKE /* @prefix(criteria.${property.name}Starts) */'smith'
/*%end*/
/*%if criteria.${property.name}NotStarts != null  */
  and ${property.columnName} NOT LIKE /* @prefix(criteria.${property.name}NotStarts) */'smith'
/*%end*/
/*%if criteria.${property.name}Ends != null  */
  and ${property.columnName} LIKE /* @suffix(criteria.${property.name}Ends) */'smith'
/*%end*/
/*%if criteria.${property.name}NotEnds != null  */
  and ${property.columnName} NOT LIKE /* @suffix(criteria.${property.name}NotEnds) */'smith'
/*%end*/
</#if>
</#if>
</#list>
/*# criteria.orderBy */
