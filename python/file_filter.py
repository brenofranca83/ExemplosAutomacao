class FileFilter:
    def filter_by_extension(self, file_list, extension):
        return [file for file in file_list if file.endswith(extension)]

    def filter_by_keyword(self, file_list, keyword):
        return [file for file in file_list if keyword in file]
