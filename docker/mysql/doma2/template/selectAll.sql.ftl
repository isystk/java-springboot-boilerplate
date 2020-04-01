SELECT
  /*%expand*/*
FROM
  ${entityDesc.tableName}
WHERE
<#list entityDesc.entityPropertyDescs as property>
<#if property.name != "version" >
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
/*%if criteria.${property.name}In != null  */
  ${property.columnName} IN /* criteria.${property.name}In */(1,2,3)
/*%end*/
/*%if criteria.${property.name}NotIn != null  */
  ${property.columnName} NOT IN /* criteria.${property.name}NotIn */(1,2,3)
/*%end*/
<#elseif property.time>
<#elseif (property.date || property.timestamp)>
<#elseif 0 lt property.name?index_of("Flg") >
<#else>
/*%if criteria.${property.name}Like != null  */
  ${property.columnName} LIKE /* @infix(criteria.${property.name}Like) */'smith'
/*%end*/
</#if>
</#if>
</#list>
