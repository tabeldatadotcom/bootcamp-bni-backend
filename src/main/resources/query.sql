SELECT produk.id,
       produk.nama,
       produk.jenis,
       produk.berat,
       produsen.id as produsen_id,
       produsen.nama as produsen_nama,
       produsen.kode as produsen_kode,
       produsen.alamat as produsen_alamat
FROM public.produk produk
         left join produsen produsen on produk.produsen_id = produsen.id
