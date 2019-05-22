create table unit
(
    id        bigint      not null
        constraint unit_pkey
            primary key,
    data      varchar(255),
    email     varchar(64) not null
        constraint uk_lkvvvrc1lmhrufnvgxd1yuh40
            unique,
    timestamp bigint,
    token     varchar(256)
        constraint uk_7825ae30wm3gpd663bmev4f7r
            unique
);
