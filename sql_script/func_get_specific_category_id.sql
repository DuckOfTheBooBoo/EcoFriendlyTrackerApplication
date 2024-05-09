delimiter //
create function get_specific_category_id(spec_cat_name varchar(255)) RETURNS INT deterministic
begin
	declare spec_cat_id INT;
    
    select specific_cat_id
    into spec_cat_id
    from specific_category
    where specific_cat_name = spec_cat_name
    collate utf8mb4_general_ci;
    
    if spec_cat_id is null then
		set spec_cat_id = 0;
    end if;
    return spec_cat_id;
end//
delimiter ;
