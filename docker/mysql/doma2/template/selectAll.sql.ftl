SELECT
  /*%expand*/*
FROM
  ${entityDesc.tableName}
WHERE
<#list entityDesc.entityPropertyDescs as property>
/*%if criteria.${property.name}Equal != null */
  ${property.columnName} = /* criteria.${property.name}Equal */<#if property.number>1<#elseif property.time>${toTime("12:34:56")}<#elseif property.date>${toDate("2010-01-23")}<#elseif property.timestamp>${toTimestamp("2010-01-23 12:34:56")}<#else>'a'</#if>
/*%end*/
/*%if criteria.${property.name}NotEqual != null */
  ${property.columnName} != /* criteria.${property.name}NotEqual */<#if property.number>1<#elseif property.time>${toTime("12:34:56")}<#elseif property.date>${toDate("2010-01-23")}<#elseif property.timestamp>${toTimestamp("2010-01-23 12:34:56")}<#else>'a'</#if>
/*%end*/
/*%if criteria.${property.name}IsNull  */
  ${property.columnName} IS NULL
/*%end*/
/*%if criteria.${property.name}IsNotNull  */
  ${property.columnName} IS NOT NULL
/*%end*/
<#if property.number>
<#elseif property.time>
<#elseif (property.date || property.timestamp)>
<#else>
</#if>
</#list>
