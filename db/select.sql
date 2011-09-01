SELECT c.name, m.name
  FROM component c,
       part_number p,
       manufacturer m,
       component_has_value cv,
       attribute_value v
 WHERE c.id              = p.component_id
   AND c.manufacturer_id = m.id
   AND c.id              = cv.component_id
   AND v.id              = cv.attribute_value_id;


SELECT DISTINCT c.id, c.name, p.part_number
  FROM component c,
       part_number p,
       manufacturer m,
       component_has_value cv,
       attribute_value v
 WHERE c.id              = p.component_id
   AND c.manufacturer_id = m.id
   AND c.id              = cv.component_id
   AND v.id              = cv.attribute_value_id
   AND (   p.part_number = '74HC74'
        OR c.name        = '74HC74'
        OR c.description = '74HC74'
        OR m.name        = '74HC74'
        OR v.value       = '74HC74');

SELECT DISTINCT c.id, c.name, p.part_number
  FROM component c,
       part_number p,
       manufacturer m,
       component_has_value cv,
       attribute_value v
 WHERE c.id              = p.component_id
   AND c.manufacturer_id = m.id
   AND c.id              = cv.component_id
   AND v.id              = cv.attribute_value_id
   AND (   p.part_number = '643212'
        OR c.name        = '643212'
        OR c.description = '643212'
        OR m.name        = '643212'
        OR v.value       = '643212');

/***********************************************/

SELECT DISTINCT c
  FROM Component c                     
  JOIN c.partNumbers p
  JOIN c.manufacturer m
  JOIN c.attributeValues v
 WHERE 1 = 2
    OR p.partNumber  = :searchString
    OR c.name        = :searchString
    OR c.description = :searchString
    OR m.name        = :searchString
    OR v.value       = :searchString;

SELECT DISTINCT c
  FROM Component c
  JOIN c.partNumbers p
  JOIN c.manufacturer m
  JOIN c.attributeValues v
 WHERE 1 = 2
    OR p.partNumber  LIKE :searchString
    OR c.name        LIKE :searchString
    OR c.description LIKE :searchString
    OR m.name        LIKE :searchString
    OR v.value       LIKE :searchString;

