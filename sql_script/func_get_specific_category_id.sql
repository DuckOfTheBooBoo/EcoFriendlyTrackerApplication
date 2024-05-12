delimiter //
create function get_specific_category_id(sub_cat_id INT, spec_cat_name varchar(255)) RETURNS INT deterministic
begin
	declare spec_cat_id INT;
    
    select specific_cat_id
    into spec_cat_id
    from specific_category spc
    where spc.specific_cat_name = spec_cat_name AND spc.sub_category_id = sub_cat_id;
    
    if spec_cat_id is null then
		set spec_cat_id = 0;
    end if;
    return spec_cat_id;
end//
delimiter ;
