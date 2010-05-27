<?php

/**
 * Класс XmlConvertor.
 * Предназначен для отдачи данных дерева с формате XML.
 *
 * @author APopov
 * @date: 2010-05-27
 */
class XmlConvertor {

    private $writer;
    private $version = '1.0';
    private $encoding = 'UTF-8';
    private $rootName = 'root';

    function __construct() {
        $this->writer = new XMLWriter();
    }

    public function convert($data) {
        $this->writer->openMemory();
        $this->writer->startDocument($this->version, $this->encoding);
        $this->writer->startElement($this->rootName);
        if (is_array($data)) {
            $this->getXML($data);
        }
        $this->writer->endElement();
        return $this->writer->outputMemory();
    }

    public function setVersion($version) {
        $this->version = $version;
    }

    public function setEncoding($encoding) {
        $this->encoding = $encoding;
    }

    public function setRootName($rootName) {
        $this->rootName = $rootName;
    }

    private function getXML($data) {
        for ($i = 0; $i < count($data); $i++) {
            $row = $data[$i];
            $this->writer->startElement('item');
            $this->writer->writeAttribute("parent_id", $row->getPid());
            $this->writer->writeAttribute("id", $row->getNid());
            $this->writer->startElement("content");
            $this->writer->startElement("name");
            // Небольшая фиксилка отображения кавычек и апострофов.
            $this->writer->writeCdata(iconv('Windows-1251', 'UTF-8', preg_replace("/(\\\')|(\\\\\")/", "'", $row->getName())));
            $this->writer->endElement();
            $this->writer->endElement();
            $this->writer->endElement();
        }
    }

}
?>
