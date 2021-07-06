# WebApp

CREATE TABLE public.review
(
    name character(20) COLLATE pg_catalog."default",
    title character(50) COLLATE pg_catalog."default",
    reason character(100) COLLATE pg_catalog."default",
    star integer
)
